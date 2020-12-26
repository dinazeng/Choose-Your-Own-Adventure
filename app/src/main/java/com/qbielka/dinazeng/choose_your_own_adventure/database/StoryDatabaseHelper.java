package com.qbielka.dinazeng.choose_your_own_adventure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StoryDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Story.db";
    public static final String TABLE = "story_table";

    public static final String ID = "ID";
    public static final String STORY = "STORY";
    public static final String NUM_BUTTONS = "NUM_BUTTONS";

    public static final String BUTTON_1_TEXT = "BUTTON_1_TEXT";
    public static final String BUTTON_2_TEXT = "BUTTON_2_TEXT";
    public static final String BUTTON_3_TEXT = "BUTTON_3_TEXT";
    public static final String BUTTON_4_TEXT = "BUTTON_4_TEXT";

    public static final String BUTTON_1_KEY = "BUTTON_1_KEY";
    public static final String BUTTON_2_KEY = "BUTTON_2_KEY";
    public static final String BUTTON_3_KEY = "BUTTON_3_KEY";
    public static final String BUTTON_4_KEY = "BUTTON_4_KEY";

    public StoryDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
