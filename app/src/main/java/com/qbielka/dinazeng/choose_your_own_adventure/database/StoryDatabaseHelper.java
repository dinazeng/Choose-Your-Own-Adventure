package com.qbielka.dinazeng.choose_your_own_adventure.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;

public class StoryDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Story.db";
    public static final String TABLE_NAME = "story_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "STORY";
    public static final String COL_3 = "NUM_BUTTONS";

    public static final String COL_4 = "BUTTON_1_TEXT";
    public static final String COL_5 = "BUTTON_2_TEXT";
    public static final String COL_6 = "BUTTON_3_TEXT";
    public static final String COL_7 = "BUTTON_4_TEXT";

    public static final String COL_8 = "BUTTON_1_KEY";
    public static final String COL_9 = "BUTTON_2_KEY";
    public static final String COL_10 = "BUTTON_3_KEY";
    public static final String COL_11 = "BUTTON_4_KEY";

    private SQLiteDatabase db;

    public StoryDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create table "+TABLE_NAME+" ( "+
                COL_1 + " INTEGER PRIMARY KEY, "+
                COL_2 + " TEXT, "+
                COL_3 + " INTEGER, " +
                COL_4 + " TEXT, " +
                COL_5 + " TEXT, " +
                COL_6 + " TEXT, " +
                COL_7 + " TEXT, " +
                COL_8 + " INTEGER, " +
                COL_9 + " INTEGER, " +
                COL_10+ " INTEGER, " +
                COL_11+ " INTEGER" +
                ")";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    /**
     * Function takes in a stateID and returns the state the ID is for.
     * If the ID is not for a valid state the program will return null right now
     * @param storyID this is the id for a row in the table
     * @return a Story, this will be null if there is no answer to the querry
     * or a story with all its information if it exists
     */
    //todo decide if it should return null or some default state which is just a reversal or something
    public Story getStory(int storyID){
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE "+COL_1+"="+storyID,null);

        // Case where there was no state with this id
        if(result == null || result.getCount() == 0){
            return null;
        }
        result.moveToFirst();

        // Extract data from the cursor
        String story = result.getString(result.getColumnIndex(COL_2));
        int numButtons = result.getInt(result.getColumnIndex(COL_3));
        String button1Text = result.getString(result.getColumnIndex(COL_4));
        String button2Text = result.getString(result.getColumnIndex(COL_5));
        String button3Text = result.getString(result.getColumnIndex(COL_6));
        String button4Text = result.getString(result.getColumnIndex(COL_7));
        int button1State = result.getInt(result.getColumnIndex(COL_8));
        int button2State = result.getInt(result.getColumnIndex(COL_9));
        int button3State = result.getInt(result.getColumnIndex(COL_10));
        int button4State = result.getInt(result.getColumnIndex(COL_11));

        // close the cursor before ending
        result.close();

        return new Story(storyID, story, numButtons,
                button1Text, button1State, button2Text, button2State,
                button3Text, button3State, button4Text, button4State);
    }

    /**
     *
     * @param storyLine a story to be added to the database
     * @return a boolean value to whether or not it has been added to the databaase
     */
    public boolean insert(Story storyLine){
        ContentValues cv = new ContentValues();
        cv.put(COL_1, storyLine.getId());
        cv.put(COL_2, storyLine.getStory());
        cv.put(COL_3, storyLine.getNumButtons());
        cv.put(COL_4, storyLine.getButton1Text());
        cv.put(COL_5, storyLine.getButton2Text());
        cv.put(COL_6, storyLine.getButton3Text());
        cv.put(COL_7, storyLine.getButton4Text());
        cv.put(COL_8, storyLine.getButton1NextState());
        cv.put(COL_9, storyLine.getButton2NextState());
        cv.put(COL_10, storyLine.getButton3NextState());
        cv.put(COL_11, storyLine.getButton4NextState());

        long result = db.insert(TABLE_NAME, null, cv);

        return result != -1;
    }
}
