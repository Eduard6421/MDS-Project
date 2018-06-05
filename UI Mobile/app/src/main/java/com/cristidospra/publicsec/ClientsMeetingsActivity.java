package com.cristidospra.publicsec;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import Controllers.CompaniesController;
import Controllers.EmployeesController;
import Controllers.MeetingsController;
import Models.Company;
import Models.Employee;
import Models.Meeting;
import Utils.GlobalData;

public class ClientsMeetingsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ImageView menuBarsImageView;

    private Button historyButton;

    private TableLayout meetingsTable;
    private TableLayout oldMeetingsTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_meetings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuBarsImageView = findViewById(R.id.meetings_menu_bars_image_view);
        historyButton = findViewById(R.id.meetings_history_button);
        meetingsTable = findViewById(R.id.meetings_table_layout);

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(ClientsMeetingsActivity.this, v);
                popupMenu.setOnMenuItemClickListener(ClientsMeetingsActivity.this);

                popupMenu.inflate(R.menu.client_overflow_menu);

                popupMenu.show();
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOldMeetings();
            }
        });

        loadUpcomingMeetings();
    }

    private void loadUpcomingMeetings() {

        ArrayList<Meeting> meetings = (ArrayList<Meeting>) MeetingsController.getAllOpenedByClient(GlobalData.getUserId());

        for (Meeting meet : meetings) {

            Integer companyID = meet.getIdCompany();
            Integer employeeID = meet.getIdEmployee();

            Company company = CompaniesController.getById(companyID);
            Employee employee = EmployeesController.getById(employeeID);

            String companyName = company != null ? company.getName() : "-";
            String employeeName = employee != null ? employee.getFirstName() + " " + employee.getLastName() : "-";

            createTableRow(meetingsTable, meet.getMeetingDate(), companyName, employeeName, meet.getDescription(), null);
        }

    }

    public void createTableRow(TableLayout meetingsTable, Date meetingDate, String meetingCompanyName, String meetingEmployee, String meetingDescription, View.OnClickListener clickListener) {

        TableRow tr = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        tr.setLayoutParams(lp);

        TextView dateTextView = new TextView(this);
        dateTextView.setLayoutParams(lp);
        dateTextView.setBackgroundColor(Color.WHITE);
        dateTextView.setText(meetingDate.toString());

        TextView companyTextView = new TextView(this);
        companyTextView.setLayoutParams(lp);
        companyTextView.setBackgroundColor(Color.WHITE);
        companyTextView.setText(meetingCompanyName);

        TextView employeeTextView = new TextView(this);
        employeeTextView.setLayoutParams(lp);
        employeeTextView.setBackgroundColor(Color.WHITE);
        employeeTextView.setText(meetingEmployee);

        TextView reasonTextView = new TextView(this);
        reasonTextView.setLayoutParams(lp);
        reasonTextView.setBackgroundColor(Color.WHITE);
        reasonTextView.setText(meetingDescription);

        tr.addView(dateTextView);
        tr.addView(companyTextView);
        tr.addView(employeeTextView);
        tr.addView(reasonTextView);

        if (clickListener != null) {
            tr.setOnClickListener(clickListener);
        }

        meetingsTable.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    private void showOldMeetings() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.history_table_popup, null);
        dialogBuilder.setView(dialogView);

        oldMeetingsTable = dialogView.findViewById(R.id.meetings_popup_table_layout);

        ArrayList<Meeting> meetings = (ArrayList<Meeting>) MeetingsController.getAllClosedByClient(GlobalData.getUserId());

        for (final Meeting meet : meetings) {

            Integer companyID = meet.getIdCompany();
            Integer employeeID = meet.getIdEmployee();

            Company company = CompaniesController.getById(companyID);
            Employee employee = EmployeesController.getById(employeeID);

            String companyName = company != null ? company.getName() : "-";
            String employeeName = employee != null ? employee.getFirstName() + " " + employee.getLastName() : "-";

            createTableRow(oldMeetingsTable, meet.getMeetingDate(), companyName, meet.getDescription(), employeeName, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openRatingPopup(meet.getId());
                }
            });
        }

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void openRatingPopup(final Integer meetingId) {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.rating_popup, null);
        dialogBuilder.setView(dialogView);

        final RatingBar ratingBar = dialogView.findViewById(R.id.rating_popup_ratingBar);
        final EditText description = dialogView.findViewById(R.id.rating_popup_description_edit_text);
        Button rateButton = dialogView.findViewById(R.id.rating_popup_rate_button);
        Button cancelButton = dialogView.findViewById(R.id.rating_popup_cancel_button);

        Meeting meeting = MeetingsController.getByMeeting(meetingId);

        ratingBar.setRating(meeting.getRating());
        description.setText(meeting.getDescription());

        final AlertDialog alertDialog = dialogBuilder.create();

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeetingsController.giveFeedback(meetingId, ratingBar.getRating(), description.getText().toString());
                alertDialog.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            case R.id.user_overflow_account:

                intent = new Intent(this, UserAccountActivity.class);
                startActivity(intent);

                return true;

            case R.id.user_overflow_meetings:

                intent = new Intent(this, ClientsMeetingsActivity.class);
                startActivity(intent);

                return true;

            case R.id.user_overflow_schedule_meeting:

                intent = new Intent(this, MeetingSchedulerActivity.class);
                startActivity(intent);

                return true;

/*              @TODO this
                case R.id.user_overflow_contact_us:

                intent = new Intent(this, ContactUsActivity.class);
                startActivity(intent);

                return true;*/

            default:
                return false;
        }
    }

}
