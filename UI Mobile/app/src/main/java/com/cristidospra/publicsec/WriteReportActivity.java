package com.cristidospra.publicsec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import Controllers.MeetingsController;
import Controllers.ReportsController;
import Models.Meeting;
import Utils.GlobalData;

public class WriteReportActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Spinner meetingsSpinner;
    private EditText descriptionEditText;

    private Button submitButton;
    private Button cancelButton;

    private ImageView menuBarsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        meetingsSpinner = findViewById(R.id.write_report_meeting_spinner);
        descriptionEditText = findViewById(R.id.write_report_description_edit_text);

        submitButton = findViewById(R.id.write_report_submit_button);
        cancelButton = findViewById(R.id.write_report_cancel_button);

        menuBarsImageView = findViewById(R.id.write_report_menu_bars_image_view);

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(WriteReportActivity.this, v);
                popupMenu.setOnMenuItemClickListener(WriteReportActivity.this);

                popupMenu.inflate(R.menu.employee_overflow_menu);


                popupMenu.show();
            }

        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeReport();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* @TODO
                    this should do something
                 */
            }
        });

        populateSpinnerValues();
    }

    private void populateSpinnerValues() {

        List<Meeting> meetings = MeetingsController.getAllByClient(GlobalData.getUserId());
        ArrayList<Integer> meetingIDs = new ArrayList<>();

        for (Meeting meet : meetings) {
            meetingIDs.add(meet.getId());
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, meetingIDs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        meetingsSpinner.setAdapter(adapter);
    }

    private void writeReport() {

        Integer meetingID = (Integer) meetingsSpinner.getSelectedItem();
        String description = String.valueOf(descriptionEditText.getText());

        ReportsController.createReport(meetingID, description);
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
