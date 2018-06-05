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
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import Controllers.ClientsController;
import Controllers.MeetingsController;
import Models.Client;
import Models.Meeting;
import Utils.GlobalData;

public class EmployeesMeetingsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ImageView menuBarsImageView;

    private Button historyButton;

    private TableLayout meetingsTable;
    private TableLayout oldMeetingsTable;

    private static String currentMeetingAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_meetings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuBarsImageView = findViewById(R.id.employees_meetings_menu_bars_image_view);
        historyButton = findViewById(R.id.employees_meetings_history_button);
        meetingsTable = findViewById(R.id.employees_meetings_table_layout);

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(EmployeesMeetingsActivity.this, v);
                popupMenu.setOnMenuItemClickListener(EmployeesMeetingsActivity.this);

                popupMenu.inflate(R.menu.employee_overflow_menu);

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

        ArrayList<Meeting> meetings = (ArrayList<Meeting>) MeetingsController.getAllOpenedByEmployee(GlobalData.getUserId());

        for (Meeting meet : meetings) {

            Integer clientID = meet.getIdClient();

            Client client = ClientsController.getById(clientID);

            String clientName = client.getFirstName() + " " + client.getLastName();
            final String clientAddress = client.getAddress();

            createTableRow(meetingsTable, meet.getMeetingDate(), clientName, clientAddress, meet.getDescription(), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentMeetingAddress = clientAddress;
                    openGoogleMaps();
                }
            });
        }
    }

    public void createTableRow(TableLayout meetingsTable, Date meetingDate, String meetingClientName, String meetingAddress, String meetingDescription, View.OnClickListener clickListener) {

        TableRow tr = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        tr.setLayoutParams(lp);

        TextView dateTextView = new TextView(this);
        dateTextView.setLayoutParams(lp);
        dateTextView.setBackgroundColor(Color.WHITE);
        dateTextView.setText(meetingDate.toString());

        TextView clientTextView = new TextView(this);
        clientTextView.setLayoutParams(lp);
        clientTextView.setBackgroundColor(Color.WHITE);
        clientTextView.setText(meetingClientName);

        TextView addressTextView = new TextView(this);
        addressTextView.setLayoutParams(lp);
        addressTextView.setBackgroundColor(Color.WHITE);
        addressTextView.setText(meetingAddress);

        TextView reasonTextView = new TextView(this);
        reasonTextView.setLayoutParams(lp);
        reasonTextView.setBackgroundColor(Color.WHITE);
        reasonTextView.setText(meetingDescription);

        tr.addView(dateTextView);
        tr.addView(clientTextView);
        tr.addView(addressTextView);
        tr.addView(reasonTextView);

        if (clickListener != null) {
            tr.setOnClickListener(clickListener);
        }

        meetingsTable.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    private void showOldMeetings() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.employees_history_table_popup, null);
        dialogBuilder.setView(dialogView);

        oldMeetingsTable = dialogView.findViewById(R.id.employees_meetings_popup_table_layout);

        ArrayList<Meeting> meetings = (ArrayList<Meeting>) MeetingsController.getAllClosedByEmployee(GlobalData.getUserId());

        for (final Meeting meet : meetings) {

            Integer clientID = meet.getIdClient();

            Client client = ClientsController.getById(clientID);

            String clientName = client.getFirstName() + " " + client.getLastName();
            String clientAddress = client.getAddress();

            createTableRow(oldMeetingsTable, meet.getMeetingDate(), clientName, clientAddress, meet.getDescription(), null);
        }

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void openGoogleMaps() {

        Intent intent = new Intent(this, GoogleMapsActivity.class);
        startActivity(intent);
    }

    public static String getCurrentMeetingAddress() {
        return currentMeetingAddress;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            case R.id.employee_overflow_account:

                intent = new Intent(this, EmployeeAccountActivity.class);
                startActivity(intent);

                return true;

            case R.id.employee_overflow_meetings:

                intent = new Intent(this, EmployeesMeetingsActivity.class);
                startActivity(intent);

                return true;

            case R.id.employee_overflow_write_report:

                intent = new Intent(this, WriteReportActivity.class);
                startActivity(intent);

                return true;

            default:
                return false;
        }
    }
}
