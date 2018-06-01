package com.cristidospra.publicsec;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;

import Controllers.LoginController;
import Utils.MySQLConnector;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private TextView createAccTextView;

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        signInButton = findViewById(R.id.login_button);
        createAccTextView = findViewById(R.id.create_account_text_view);

        MySQLConnector.connectToDatabase();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        createAccTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void login() {

        String username = String.valueOf(userNameEditText.getText());
        String password = String.valueOf(passwordEditText.getText());

        if (username.length() <= 0 || password.length() <= 0) {
            createAlertDialog("Username and password must not be empty.");
        } else {

            boolean clientSuccesConnection = LoginController.connectClient(username, password);
            boolean employeeSuccesConnection = LoginController.connectEmployee(username, password);

            if (clientSuccesConnection == true) {
                Intent intent = new Intent(this, UserAccountActivity.class);
                startActivity(intent);

            } else if (employeeSuccesConnection == true) {
                Intent intent = new Intent(this, EmployeeAccountActivity.class);
                startActivity(intent);
            } else {

                createAlertDialog("User does not exist / wrong password!");
            }
        }
    }

    private void createAccount() {

        Intent intent = new Intent(this, UserCreateAccountActivity.class);
        startActivity(intent);
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
