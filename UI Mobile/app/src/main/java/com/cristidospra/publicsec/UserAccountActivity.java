package com.cristidospra.publicsec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UserAccountActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText addressEditText;

    private Button updateDataButton;
    private Button changePasswordButton;

    private ImageView menuBarsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usernameEditText = findViewById(R.id.user_username_edit_text);
        emailEditText = findViewById(R.id.user_email_edit_text);
        phoneEditText = findViewById(R.id.user_phone_edit_text);
        addressEditText = findViewById(R.id.user_address_edit_text);

        updateDataButton = findViewById(R.id.user_update_data_button);
        changePasswordButton = findViewById(R.id.user_change_password_button);

        menuBarsImageView = findViewById(R.id.user_account_menu_bars_image_view);

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
