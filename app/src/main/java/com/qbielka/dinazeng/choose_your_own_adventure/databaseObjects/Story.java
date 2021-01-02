package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

import android.database.Cursor;

import com.qbielka.dinazeng.choose_your_own_adventure.CSVReader;

import java.util.ArrayList;

public class Story {

    private static final int FIRST_BUTTON_COL = 3;
    public static final int ID_COLUMN = 0;
    public static final int NUM_BUTTONS_COLUMN = 2;
    public static final int STORY_COLUMN = 1;

    private int id;
    private String story;
    private ArrayList<Button> buttonArr;

    /**
     * Build the story by parsing a CSV line
     * @param CSVLine a row in a csv file
     */
    public Story(String CSVLine){
        ArrayList<String> columns = CSVReader.breakCSVLineIntoColumns(CSVLine);
        int numButtons = Integer.parseInt(columns.get(NUM_BUTTONS_COLUMN));

        setId(Integer.parseInt(columns.get(ID_COLUMN)));
        setStory(story = columns.get(STORY_COLUMN));

        buttonArr = new ArrayList<>();
        for (int n = 0; n < numButtons; n++){

            //Button Effects are always first
            String buttonEffects = columns.get(FIRST_BUTTON_COL + 3*n );
            //ButtonText is always second
            String buttonText = columns.get(FIRST_BUTTON_COL+ 3*n + 1);
            //Button Keys are always third
            int buttonKey = Integer.parseInt(columns.get(FIRST_BUTTON_COL + 3*n +2));
            buttonArr.add(new Button(buttonKey, buttonText, buttonEffects));
        }
    }

    public Story (int ID, String story, ArrayList<Button> buttonArr){
        setId(ID);
        setStory(story);
        setButtonArr(buttonArr);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

     //Build the story by providing all the member data

    public ArrayList<Button> getButtonArr() {
        return buttonArr;
    }

    public void setButtonArr(ArrayList<Button> buttonArr) {
        this.buttonArr = buttonArr;
    }
}

