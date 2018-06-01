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

import Controllers.ClientsController;
import Models.Client;
import Utils.GlobalData;

public class UserAccountActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

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

                PopupMenu popupMenu = new PopupMenu(UserAccountActivity.this, v);
                popupMenu.setOnMenuItemClickListener(UserAccountActivity.this);

                popupMenu.inflate(R.menu.client_overflow_menu);

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

        Client myClient = ClientsController.getByUsername(GlobalData.getUsername());

        usernameEditText.setClickable(false);
        //usernameEditText.setActivated(false);

        usernameEditText.setText(myClient.getUsername());
        emailEditText.setText(myClient.getEmail());
        phoneEditText.setText(myClient.getPhone());
        addressEditText.setText(myClient.getAddress());
    }

    private void updateData() {

        String currentUserName = String.valueOf(usernameEditText.getText());
        String currentEmail =  String.valueOf(emailEditText.getText());
        String currentPhoneNr = String.valueOf(phoneEditText.getText());
        String currentAddress = String.valueOf(addressEditText.getText());

        ClientsController.updateData(currentEmail, currentPhoneNr, currentAddress);
    }

    private void changePassword() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.password_change_popup, null);
        dialogBuilder.setView(dialogView);

        final EditText oldPasswordEditText = dialogView.findViewById(R.id.old_password_edit_text);
        final EditText newPasswordEditText = dialogView.findViewById(R.id.new_password_edit_text);
        final EditText confirmPasswordEditText = dialogView.findViewById(R.id.confirm_password_edit_text);

        Button changePasswordButton = dialogView.findViewById(R.id.change_password_button);

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

                    if (newPassword.length() < 1) {
                        createAlertDialog("Password cant be empty.");
                    } else {

                        boolean result = ClientsController.changePassword(oldPassword, newPassword);

                        if (result == false) {
                            createAlertDialog("Inserted password not correct.");
                        } else {
                            createAlertDialog("Password succesfully changed.");
                        }
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
