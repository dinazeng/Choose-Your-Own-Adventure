package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

import android.database.Cursor;

import com.qbielka.dinazeng.choose_your_own_adventure.CSVReader;

import java.util.ArrayList;

public class Story {

    int id;
    private String story;
    private ArrayList<Button> buttonArr;

    /**
     * Build the story by parsing a CSV line
     * @param CSVLine a row in a csv file
     */
    public Story(String CSVLine){
        ArrayList<String> columns = CSVReader.breakCSVLineIntoColumns(CSVLine);
        int numButtons = Integer.parseInt(columns.get(2));

        setId(Integer.parseInt(columns.get(0)));
        setStory(story = columns.get(1));

        buttonArr = new ArrayList<>();
        for (int n = 0; n < numButtons; n++){
            String buttonText = columns.get(3+n);
            int buttonKey = Integer.parseInt(columns.get(3+n+numButtons));
            buttonArr.add(new Button(buttonKey, buttonText));
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

