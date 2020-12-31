package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

import android.database.Cursor;

import com.qbielka.dinazeng.choose_your_own_adventure.CSVReader;

import java.util.ArrayList;

public class Story {

    int id;
    private String story;
    private int numButtons;

    private String button1Text;
    private int button1NextState;

    private String button2Text;
    private int button2NextState;

    private String button3Text;
    private int button3NextState;

    private String button4Text;
    private int button4NextState;

    /**
     * Build the story by parsing a CSV line
     * @param CSVLine a row in a csv file
     */
    public Story(String CSVLine){
        ArrayList<String> columns = CSVReader.breakCSVLineIntoColumns(CSVLine);

        setId(Integer.parseInt(columns.get(0)));
        setStory(story = columns.get(1));
        setNumButtons(numButtons = Integer.parseInt(columns.get(2)));

        //Todo replace this with an array of objects that will be read in and out of the database
        int b1Position = 3;
        int b2Position = 4;
        int b3Position = 5;
        int b4Position = 6;

        if(numButtons > 0){
            setButton1Text(columns.get(b1Position));
            setButton1NextState(Integer.parseInt(columns.get(b1Position+numButtons)));
        }
        if(numButtons > 1){
            setButton2Text(columns.get(b2Position));
            setButton2NextState(Integer.parseInt(columns.get(b2Position+numButtons)));
        }
        if(numButtons > 2){
            setButton3Text(columns.get(b3Position));
            setButton3NextState(Integer.parseInt(columns.get(b3Position+numButtons)));
        }
        if(numButtons > 3){
            setButton4Text(columns.get(b4Position));
            setButton4NextState(Integer.parseInt(columns.get(b4Position+numButtons)));
        }

    }


    /**
     * Build the story by providing all the member data
     *
     */
    public Story(int id, String story, int numButtons,
                 String button1Text, int button1NextState,
                 String button2Text, int button2NextState,
                 String button3Text, int button3NextState,
                 String button4Text, int button4NextState
                 ){
        // Start of constructor
        setId(id);
        setStory(story);
        setNumButtons(numButtons);

        setButton1Text(button1Text);
        setButton1NextState(button1NextState);

        setButton2Text(button2Text);
        setButton2NextState(button2NextState);

        setButton3Text(button3Text);
        setButton3NextState(button3NextState);

        setButton4Text(button4Text);
        setButton4NextState(button4NextState);
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

    public int getNumButtons() {
        return numButtons;
    }

    public void setNumButtons(int numButtons) {
        this.numButtons = numButtons;
    }

    public String getButton1Text() {
        return button1Text;
    }

    public void setButton1Text(String button1Text) {
        this.button1Text = button1Text;
    }

    public int getButton1NextState() {
        return button1NextState;
    }

    public void setButton1NextState(int button1NextState) {
        this.button1NextState = button1NextState;
    }

    public String getButton2Text() {
        return button2Text;
    }

    public void setButton2Text(String button2Text) {
        this.button2Text = button2Text;
    }

    public int getButton2NextState() {
        return button2NextState;
    }

    public void setButton2NextState(int button2NextState) {
        this.button2NextState = button2NextState;
    }

    public String getButton3Text() {
        return button3Text;
    }

    public void setButton3Text(String button3Text) {
        this.button3Text = button3Text;
    }

    public int getButton3NextState() {
        return button3NextState;
    }

    public void setButton3NextState(int button3NextState) {
        this.button3NextState = button3NextState;
    }

    public String getButton4Text() {
        return button4Text;
    }

    public void setButton4Text(String button4Text) {
        this.button4Text = button4Text;
    }

    public int getButton4NextState() {
        return button4NextState;
    }

    public void setButton4NextState(int button4NextState) {
        this.button4NextState = button4NextState;
    }

}

