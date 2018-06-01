package com.cristidospra.publicsec;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class MeetingsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ImageView menuBarsImageView;

    private Button historyButton;

    private TableLayout meetingsTable;

    /* @TODO
        CAREFULL TO USE THE SAME CLASS FOR BOTH EMPLOYEE AND USER
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuBarsImageView = findViewById(R.id.meetings_menu_bars_image_view);
        historyButton = findViewById(R.id.meetings_history_button);
        meetingsTable = findViewById(R.id.meetings_table_layout);

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MeetingsActivity.this, v);
                popupMenu.setOnMenuItemClickListener(MeetingsActivity.this);

                if (GlobalData.getUserType().equalsIgnoreCase("client")) {
                    popupMenu.inflate(R.menu.client_overflow_menu);
                }
                else if (GlobalData.getUserType().equalsIgnoreCase("employee")) {
                    popupMenu.inflate(R.menu.employee_overflow_menu);
                }

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

        ArrayList<Meeting> meetings = (ArrayList<Meeting>) MeetingsController.getAll();

        for (Meeting meet : meetings) {

            Integer companyID = meet.getIdCompany();
            Integer employeeID = meet.getIdEmployee();

            Company company = CompaniesController.getById(companyID);
            Employee employee = EmployeesController.getById(employeeID);

            createTableRow(meet.getMeetingDate(), company.getName(), meet.getDescription(), employee.getFirstName() + " " + employee.getLastName());
        }

    }

    public void createTableRow(Date meetingDate, String meetingCompanyName, String meetingDescription, String meetingEmployee) {

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

        TextView reasonTextView = new TextView(this);
        reasonTextView.setLayoutParams(lp);
        reasonTextView.setBackgroundColor(Color.WHITE);
        reasonTextView.setText(meetingDescription);

        TextView employeeTextView = new TextView(this);
        employeeTextView.setLayoutParams(lp);
        employeeTextView.setBackgroundColor(Color.WHITE);
        employeeTextView.setText(meetingEmployee);

        tr.addView(dateTextView);
        tr.addView(companyTextView);
        tr.addView(reasonTextView);
        tr.addView(employeeTextView);

        meetingsTable.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    private void showOldMeetings() {
        /* @TODO
            do this
         */
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            /* EMPLOYEE SIDE */
            case R.id.employee_overflow_account:

                intent = new Intent(this, EmployeeAccountActivity.class);
                startActivity(intent);

                return true;

            case R.id.employee_overflow_meetings:

                intent = new Intent(this, MeetingsActivity.class);
                startActivity(intent);

                return true;

            case R.id.employee_overflow_write_report:

                intent = new Intent(this, WriteReportActivity.class);
                startActivity(intent);

                return true;


            /* CLIENT SIDE */
            case R.id.user_overflow_account:

                intent = new Intent(this, UserAccountActivity.class);
                startActivity(intent);

                return true;

            case R.id.user_overflow_meetings:

                intent = new Intent(this, MeetingsActivity.class);
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
