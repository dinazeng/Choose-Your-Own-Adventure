package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qbielka.dinazeng.choose_your_own_adventure.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        createButton();
    }

    public void createButton(){
        Button startButton = findViewById(R.id.menu_start);
        Button statisticsButton = findViewById(R.id.menu_statistics);
        Button settingsButton = findViewById(R.id.menu_settings);
        Button creditsButton = findViewById(R.id.menu_about);

        //start button onclick listener
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(startIntent);
            }
        });
        //statistics button onclick listener
        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), StatisticsActivity.class);
                startActivity(startIntent);
            }
        });

        //settings button onclick listener
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(startIntent);
            }
        });

        //settings button onclick listener
        creditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CreditsActivity.class);
                startActivity(startIntent);
            }
        });
    }
}