package com.cristidospra.publicsec;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Controllers.ClientsController;

public class UserCreateAccountActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText addressEditText;
    private EditText phoneNumberEditText;
    private EditText emailEditText;

    private Button createAccButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_create_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstNameEditText = findViewById(R.id.createacc_first_name_text);
        lastNameEditText = findViewById(R.id.createacc_last_name_edit_text);
        usernameEditText = findViewById(R.id.createacc_username_edit_text);
        passwordEditText = findViewById(R.id.createacc_password_edit_text);
        addressEditText = findViewById(R.id.createacc_address_edit_text);
        phoneNumberEditText = findViewById(R.id.createacc_phone_edit_text);
        emailEditText = findViewById(R.id.createacc_email_edit_text);

        createAccButton = findViewById(R.id.createacc_button);

        createAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {

        String firstName = String.valueOf(firstNameEditText.getText());
        String lastName = String.valueOf(lastNameEditText.getText());
        String username = String.valueOf(usernameEditText.getText());
        String password = String.valueOf(passwordEditText.getText());
        String address = String.valueOf(addressEditText.getText());
        String phoneNumber = String.valueOf(phoneNumberEditText.getText());
        String email = String.valueOf(emailEditText.getText());

        boolean result = ClientsController.registerClient(firstName, lastName, username, password, address, phoneNumber, email);

        if (result == false) {
            createAlertDialog("Failed to create your account. Please try again.");
        }
    }

    private void createAlertDialog(String errorMessage) {
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
    }
}
