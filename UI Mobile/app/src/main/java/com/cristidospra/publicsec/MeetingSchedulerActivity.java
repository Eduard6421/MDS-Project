package com.cristidospra.publicsec;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import Controllers.CompaniesController;
import Controllers.MeetingsController;
import Models.Company;
import Utils.GlobalData;

public class MeetingSchedulerActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Spinner companySpinner;
    private EditText dateEditText;
    private EditText issueEditText;

    private Button scheduleButton;

    private ImageView menuBarsImageView;

    private Date wantedDate;
    private SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_scheduler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        companySpinner = findViewById(R.id.meeting_scheduler_company_spinner);
        dateEditText = findViewById(R.id.meeting_scheduler_date_edit_text);
        issueEditText = findViewById(R.id.meeting_scheduler_issue_edit_text);

        scheduleButton = findViewById(R.id.meeting_scheduler_schdule_button);

        menuBarsImageView = findViewById(R.id.meeting_scheduler_menu_bars_image_view);

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MeetingSchedulerActivity.this, v);
                popupMenu.setOnMenuItemClickListener(MeetingSchedulerActivity.this);

                popupMenu.inflate(R.menu.client_overflow_menu);

                popupMenu.show();
            }

        });

        loadCompanies();

        wantedDate = new Date();
        simpleDateFormat = new SimpleDateFormat("dd.MM.YYYY");
        dateEditText.setText(simpleDateFormat.format(wantedDate));

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schedule();
            }
        });

        //dateEditText.setEnabled(false);
        //dateEditText.setActivated(false);
        dateEditText.setFocusable(false);
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCalendar();
            }
        });
    }

    private void loadCalendar() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.calendar_popup, null);
        dialogBuilder.setView(dialogView);

        final CalendarView calendar = dialogView.findViewById(R.id.calendar_view_popup);

        calendar.setDate(wantedDate.getTime());

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                wantedDate = new Date(year - 1900, month, dayOfMonth);
            }
        });

        final AlertDialog alertDialog = dialogBuilder.create();

        Button confirmButton = dialogView.findViewById(R.id.calendar_popup_ok_button);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateEditText.setText(simpleDateFormat.format(wantedDate));
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    private void loadCompanies() {

        List<Company> companies = CompaniesController.getByClient(GlobalData.getUserId());

        String[] companyNames = new String[companies.size()];

        for (Integer i = 0; i < companyNames.length; ++i) {
            companyNames[i] = companies.get(i).getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, companyNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        companySpinner.setAdapter(adapter);
    }

    private void schedule() {

        Company comp = CompaniesController.getByName(companySpinner.getSelectedItem().toString());

        Date today = new Date();

        if (wantedDate.after(today)) {

            MeetingsController.createMeeting(GlobalData.getUserId(),
                    comp.getId(),
                    new java.sql.Date(wantedDate.getTime()),
                    issueEditText.getText().toString());

            createAlertDialog("Meeting succesfully scheduled.");
        }
        else {
            createAlertDialog("The selected date is not available");
        }

    }

    private AlertDialog createAlertDialog(String errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(errorMessage)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

        return alert;
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
