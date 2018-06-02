package com.cristidospra.publicsec;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import Controllers.EmployeesController;
import Models.Employee;
import Utils.GlobalData;

public class EmployeeAccountActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

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

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(EmployeeAccountActivity.this, v);
                popupMenu.setOnMenuItemClickListener(EmployeeAccountActivity.this);

                popupMenu.inflate(R.menu.employee_overflow_menu);


                popupMenu.show();
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

        completeInfo();

    }

    private void completeInfo() {

        Employee myEmployee = EmployeesController.getByUsername(GlobalData.getUsername());

        usernameEditText.setClickable(false);
        //usernameEditText.setActivated(false);
        ratingBar.setClickable(false);
        //ratingBar.setActivated(false);

        usernameEditText.setText(myEmployee.getUsername());
        emailEditText.setText(myEmployee.getEmail());
        phoneEditText.setText(myEmployee.getPhone());

        ratingBar.setRating(myEmployee.getRating());
    }

    private void updateData() {

        String currentUserName = String.valueOf(usernameEditText.getText());
        String currentEmail =  String.valueOf(emailEditText.getText());
        String currentPhoneNr = String.valueOf(phoneEditText.getText());

        EmployeesController.updateData(currentEmail, currentPhoneNr);
    }

    private void changePassword() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.password_change_popup, null);
        dialogBuilder.setView(dialogView);

        final EditText oldPasswordEditText = findViewById(R.id.old_password_edit_text);
        final EditText newPasswordEditText = findViewById(R.id.new_password_edit_text);
        final EditText confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text);

        Button changePasswordButton = findViewById(R.id.change_password_button);

        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String oldPassword = String.valueOf(oldPasswordEditText.getText());
                String newPassword = String.valueOf(newPasswordEditText.getText());
                String confirmPassword = String.valueOf(confirmPasswordEditText.getText());

                if (!newPassword.contentEquals(confirmPassword)) {
                    createAlertDialog("The inserted passwords do not match.");
                }
                else {
                    boolean result = EmployeesController.changePassword(oldPassword, newPassword);

                    if (result == false) {
                        createAlertDialog("Inserted password not correct.");
                    }
                    else {
                        createAlertDialog("Password succesfully changed.");
                    }
                }
            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
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

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {
            case R.id.employee_overflow_account:

                intent = new Intent(this, EmployeeAccountActivity.class);
                startActivity(intent);

                return true;

            case R.id.employee_overflow_meetings:

                intent = new Intent(this, ClientsMeetingsActivity.class);
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

