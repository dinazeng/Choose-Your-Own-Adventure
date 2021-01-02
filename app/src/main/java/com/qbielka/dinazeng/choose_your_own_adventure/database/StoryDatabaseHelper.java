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

    public static final String COL_1 = "ID";
    public static final String COL_2 = "STORY";

    public static final String COL_A = "BUTTON_KEY";
    public static final String COL_B = "BUTTON_TEXT";
    public static final String COL_C = "STORY_ID";
    public static final String COL_D = "ID";

    private SQLiteDatabase db;

    public StoryDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStoryTable = "Create table "+STORY_TABLE+" ( "+
                COL_1 + " INTEGER PRIMARY KEY, "+
                COL_2 + " TEXT" +
                ")";
        String createButtonTable = "Create table "+ BUTTON_TABLE+" ( "+
                COL_D + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                COL_B + " TEXT, "+
                COL_C + " INTEGER, " +
                COL_A + " INTEGER" +
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
        Cursor result = db.rawQuery("SELECT * FROM " + STORY_TABLE + " WHERE "+COL_1+"="+storyID,null);
        Cursor buttonResult = db.rawQuery("SELECT * FROM " + BUTTON_TABLE + " WHERE "+COL_C+"="+storyID,null);

        // Case where there was no state with this id
        if(result == null || result.getCount() == 0){
            return null;
        }
        result.moveToFirst();
        buttonResult.moveToFirst();

        // Extract data from the cursor
        String story = result.getString(result.getColumnIndex(COL_2));
        int numButtons = buttonResult.getCount();
        ArrayList <Button> buttonArr = new ArrayList<Button>();
        String buttonText = buttonResult.getString(buttonResult.getColumnIndex(COL_B));
        int buttonKey = buttonResult.getInt(buttonResult.getColumnIndex(COL_A));
        buttonArr.add(new Button (buttonKey, buttonText));
        while (buttonResult.moveToNext()) {
            buttonText = buttonResult.getString(buttonResult.getColumnIndex(COL_B));
            buttonKey = buttonResult.getInt(buttonResult.getColumnIndex(COL_A));
            buttonArr.add(new Button(buttonKey, buttonText));
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
        storyRow.put(COL_1, storyLine.getId());
        storyRow.put(COL_2, storyLine.getStory());

        ContentValues buttonRow = new ContentValues();
        for (Button button: storyLine.getButtonArr()) {
            buttonRow.put(COL_A, button.getButtonKey());
            buttonRow.put(COL_B, button.getButtonText());
            buttonRow.put(COL_C, storyLine.getId());
            db.insert(BUTTON_TABLE, null, buttonRow);
        }

        long result = db.insert(STORY_TABLE, null, storyRow);

        return result != -1;
    }
}
