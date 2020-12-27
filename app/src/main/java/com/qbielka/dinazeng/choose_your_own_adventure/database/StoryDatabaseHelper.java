package com.qbielka.dinazeng.choose_your_own_adventure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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

    public StoryDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
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
                ");";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
