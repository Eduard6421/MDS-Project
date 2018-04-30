package com.cristidospra.publicsec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private TextView createAccTextView;
    private TextView tradeMarkTextView;

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        signInButton = findViewById(R.id.login_button);
        createAccTextView = findViewById(R.id.create_account_text_view);
        tradeMarkTextView = findViewById(R.id.trademark_text_view);

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

        /* @TODO
            do something with username and password
         */
    }

    private void createAccount() {

        Intent intent = new Intent(this, UserCreateAccountActivity.class);
    }
}
