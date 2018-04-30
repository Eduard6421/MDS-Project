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
import android.widget.RatingBar;

public class EmployeeAccountActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;

    private RatingBar ratingBar;

    private Button updateDataButton;
    private Button changePasswordButton;

    private ImageView menuBarsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usernameEditText = findViewById(R.id.employee_username_edit_text);
        emailEditText = findViewById(R.id.employee_email_edit_text);
        phoneEditText = findViewById(R.id.employee_phone_edit_text);

        ratingBar = findViewById(R.id.employee_ratingBar);

        updateDataButton = findViewById(R.id.employee_update_data_button);
        changePasswordButton = findViewById(R.id.employee_change_password_button);

        menuBarsImageView = findViewById(R.id.employee_menu_bars_image_view);

        completeInfo();

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* @TODO
                  menu popup in the corner
                 */
            }
        });

        updateDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });
    }

    private void completeInfo() {

        /* @TODO
          fill in the fields with info from database
         */
    }

    private void updateData() {
        /* @TODO
          update the database with the new info
         */
    }

    private void changePassword() {
        /* @TODO
            open new password popup and update in database
         */
    }
}
