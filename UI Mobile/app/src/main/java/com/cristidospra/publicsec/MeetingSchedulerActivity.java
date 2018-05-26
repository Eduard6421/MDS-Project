package com.cristidospra.publicsec;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class MeetingSchedulerActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Spinner companySpinner;
    private EditText dateEditText;
    private EditText issueEditText;

    private Button scheduleButton;

    private ImageView menuBarsImageView;

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

        menuBarsImageView = findViewById(R.id.employee_menu_bars_image_view);

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MeetingSchedulerActivity.this, v);
                popupMenu.setOnMenuItemClickListener(MeetingSchedulerActivity.this);

                popupMenu.inflate(R.menu.client_overflow_menu);

                popupMenu.show();

            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schedule();
            }
        });
    }

    private void schedule() {
        /* @TODO
        schedule a meeting
         */
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
