package com.cristidospra.publicsec;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class WriteReportActivty extends AppCompatActivity {

    private Spinner companySpinner;
    private EditText descriptionEditText;

    private Button submitButton;
    private Button cancelButton;

    private ImageView menuBarsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_report_activty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        companySpinner = findViewById(R.id.write_report_meeting_spinner);
        descriptionEditText = findViewById(R.id.write_report_description_edit_text);

        submitButton = findViewById(R.id.write_report_submit_button);
        cancelButton = findViewById(R.id.write_report_cancel_button);

        menuBarsImageView = findViewById(R.id.employee_menu_bars_image_view);

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* @TODO
                  menu popup in the corner
                 */
            }
        });

        /* @TODO
            populate spinner with companies from database
         */

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeReport();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void writeReport() {
        /* @TODO
        send report to the chosen company
         */
    }
}
