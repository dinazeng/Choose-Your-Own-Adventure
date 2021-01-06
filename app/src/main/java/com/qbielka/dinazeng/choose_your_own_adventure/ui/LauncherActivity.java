package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.database.StoryDatabaseHelper;
import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;
import com.qbielka.dinazeng.choose_your_own_adventure.model.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LauncherActivity extends AppCompatActivity {

    private StoryDatabaseHelper db;

    private static final String SHARED_PREFERENCES_ACCESS = "ChooseYourOwnAdventureAccess";
    private static final String FIRST_TIME_CODE = "FIRST_TIME_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        db = new StoryDatabaseHelper(this);
        SharedPreferences savedGame = this.getSharedPreferences(SHARED_PREFERENCES_ACCESS, Context.MODE_PRIVATE);
        boolean firstTimeRunning = savedGame.getBoolean(FIRST_TIME_CODE, true);


        try {
            if(firstTimeRunning){
                // Read the CSV file
                readCSVFileIntoDatabase();

                // Save the face we have run this once into the sharedPreferences
                SharedPreferences.Editor editor = savedGame.edit();
                editor.putBoolean(FIRST_TIME_CODE, false);
                editor.apply();

                // Singleton saves the starting state for the Game to use.
                Singleton.getInstance(this).gameState.setCurrentDatabaseStoryKey(1);
                Singleton.getInstance(this).gameState.setTime(100);
                Singleton.saveGame(this);
            }
            startActivity(intent);
        } catch (IOException e){
            // todo????
            // I have no solution for what happens right now the app essentially needs to crash
            // I freeze on this screen for now
        }
    }

    private void readCSVFileIntoDatabase() throws IOException {
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.story_input);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addLineToDatabase(line);
            }
        }
    }

    private void addLineToDatabase(String line) {
        if(line == null || line.length() < 2){
            return;
        }
        db.insert(new Story(line));
    }


}