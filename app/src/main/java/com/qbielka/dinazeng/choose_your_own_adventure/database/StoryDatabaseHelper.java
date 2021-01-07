package com.qbielka.dinazeng.choose_your_own_adventure.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Button;
import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;

import java.util.ArrayList;

public class StoryDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Story.db";
    public static final String STORY_TABLE = "story_table";
    public static final String BUTTON_TABLE = "button_table";

    public static final String STORY_ID = "ID";
    public static final String STORY_STORY = "STORY";

    public static final String BUTTON_KEY = "BUTTON_KEY";
    public static final String BUTTON_TEXT = "BUTTON_TEXT";
    public static final String BUTTON_STORY_ID = "STORY_ID";
    public static final String BUTTON_EFFECT = "BUTTON_EFFECT";
    public static final String BUTTON_ID = "ID";

    private SQLiteDatabase db;

    public StoryDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStoryTable = "Create table "+STORY_TABLE+" ( "+
                STORY_ID + " INTEGER PRIMARY KEY, "+
                STORY_STORY + " TEXT" +
                ")";
        String createButtonTable = "Create table "+ BUTTON_TABLE+" ( "+
                BUTTON_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                BUTTON_TEXT + " TEXT, "+
                BUTTON_EFFECT + " TEXT, "+
                BUTTON_STORY_ID + " INTEGER, " +
                BUTTON_KEY + " INTEGER" +
                ")";
        db.execSQL(createStoryTable);
        db.execSQL(createButtonTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+STORY_TABLE);
        onCreate(db);
    }


    /**
     * Function takes in a stateID and returns the state the ID is for.
     * If the ID is not for a valid state the program will return null right now
     * @param storyID this is the id for a row in the table
     * @return a Story, this will be null if there is no answer to the querry
     * or a story with all its information if it exists
     */
    public Story getStory(int storyID){
        Cursor result = db.rawQuery("SELECT * FROM " + STORY_TABLE + " WHERE "+ STORY_ID +"="+storyID,null);
        Cursor buttonResult = db.rawQuery("SELECT * FROM " + BUTTON_TABLE + " WHERE "+BUTTON_STORY_ID+"="+storyID,null);

        // Case where there was no state with this id
        if(result == null || result.getCount() == 0){
            return null;
        }
        result.moveToFirst();
        buttonResult.moveToFirst();

        // Extract data from the cursor
        // Story Table
        String story = result.getString(result.getColumnIndex(STORY_STORY));

        //Button Table
        ArrayList <Button> buttonArr = new ArrayList<>();
        String buttonText = buttonResult.getString(buttonResult.getColumnIndex(BUTTON_TEXT));
        String buttonEffects = buttonResult.getString(buttonResult.getColumnIndex(BUTTON_EFFECT));
        int buttonKey = buttonResult.getInt(buttonResult.getColumnIndex(BUTTON_KEY));
        buttonArr.add(new Button (buttonKey, buttonText,buttonEffects));

        // Add buttons to the story
        int numTimes = 0;
        while (buttonResult.moveToNext()) {
            buttonText = buttonResult.getString(buttonResult.getColumnIndex(BUTTON_TEXT));
            buttonEffects = buttonResult.getString(buttonResult.getColumnIndex(BUTTON_EFFECT));
            buttonKey = buttonResult.getInt(buttonResult.getColumnIndex(BUTTON_KEY));
            buttonArr.add(new Button(buttonKey, buttonText, buttonEffects));
        }

        // close the cursor before ending
        result.close();
        buttonResult.close();
        return new Story(storyID, story, buttonArr);
    }

    /**
     *
     * @param storyLine a story to be added to the database
     * @return a boolean value to whether or not it has been added to the databaase
     */
    public boolean insert(Story storyLine){
        ContentValues storyRow = new ContentValues();
        storyRow.put(STORY_ID, storyLine.getId());
        storyRow.put(STORY_STORY, storyLine.getStory());

        ContentValues buttonRow = new ContentValues();
        for (Button button: storyLine.getButtonArr()) {
            buttonRow.put(BUTTON_KEY, button.getButtonKey());
            buttonRow.put(BUTTON_TEXT, button.getButtonText());
            buttonRow.put(BUTTON_EFFECT, button.getStringButtonEffects());
            buttonRow.put(BUTTON_STORY_ID, storyLine.getId());
            db.insert(BUTTON_TABLE, null, buttonRow);
        }

        long result = db.insert(STORY_TABLE, null, storyRow);

        return result != -1;
    }
}
