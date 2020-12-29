package com.qbielka.dinazeng.choose_your_own_adventure.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.database.StoryDatabaseHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LauncherActivity extends AppCompatActivity {

    StoryDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        db = new StoryDatabaseHelper(this);
        try {
            todo();
        } catch (IOException e){
            // todo????
            // I have no solution for what happens right now the app essentially needs to crash
        }
        startActivity(intent);
    }

    private void todo() throws IOException {
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.story_input);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                addLineToDatabase(line);
            }
        } finally {
            reader.close();
        }
    }

    private void addLineToDatabase(String line) {
        //todo this
    }


}