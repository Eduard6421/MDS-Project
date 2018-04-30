package com.cristidospra.publicsec;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MeetingsActivity extends AppCompatActivity {

    private ImageView menuBarsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuBarsImageView = findViewById(R.id.employee_menu_bars_image_view);

        menuBarsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* @TODO
                  menu popup in the corner
                 */
            }
        });
    }

}
