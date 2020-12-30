package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

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

    public Story(String CSVLine){
        ArrayList<String> columns = breakCSVLineIntoColumns(CSVLine);

        id = Integer.parseInt(columns.get(0));
        story = columns.get(1);
        numButtons = Integer.parseInt(columns.get(2));

        //Todo replace this with an array of objects that will be read in and out of the database
        int b1Position = 3;
        int b2Position = 4;
        int b3Position = 5;
        int b4Position = 6;

        if(numButtons > 0){
            button1Text = columns.get(b1Position);
            button1NextState = Integer.parseInt(columns.get(b1Position+numButtons));
        }
        if(numButtons > 1){
            button1Text = columns.get(b2Position);
            button1NextState = Integer.parseInt(columns.get(b2Position+numButtons));
        }
        if(numButtons > 2){
            button1Text = columns.get(b3Position);
            button1NextState = Integer.parseInt(columns.get(b3Position+numButtons));
        }
        if(numButtons > 3){
            button1Text = columns.get(b4Position);
            button1NextState = Integer.parseInt(columns.get(b4Position+numButtons));
        }

        //todo talk to Dina about code flexibility
//        id = Integer.valueOf(story.charAt(0));
//
//        story = story.substring(story.indexOf(',') + 1);
//        this.story = story.substring(0, story.indexOf(','));
//        story = story.substring(story.indexOf(',') + 1);
//
//        numButtons = Integer.valueOf(story.charAt(0));
//        story = story.substring(story.indexOf(',') + 1);
//
//        button1Text = story.substring(0, story.indexOf(','));
//        story = story.substring(story.indexOf(',') + 1);
//        button2Text = story.substring(0, story.indexOf(','));
//        story = story.substring(story.indexOf(',') + 1);
//        button3Text = story.substring(0, story.indexOf(','));
//        story = story.substring(story.indexOf(',') + 1);
//
//        button1NextState = Integer.valueOf(story.charAt(0));
//        button2NextState = Integer.valueOf(story.charAt(2));
//        button3NextState = Integer.valueOf(story.charAt(4));
    }

    private static ArrayList<String> breakCSVLineIntoColumns(String CSVLine){
        ArrayList<String> arr = new ArrayList<>();

        for(int index = 0; index < CSVLine.length(); index++){
            // Escape Characters will be handled
            if(CSVLine.charAt(index) == '\\'){
                //todo figure out how I handle escape chars
                // for now skip the next character like it doesn't exist
                index++;
            }
            //Handling for a Quote Mark, note that this is not an escaped quote mark
            else if(CSVLine.charAt(index) == '\"'){
                // first iterate to the next character
                index++;
                // then check for the next unescaped Quote mark
                for (;index < CSVLine.length(); index++){
                    // Ensure no escaped Quote marks break out of the enclosed quotes
                    if(CSVLine.charAt(index) == '\\'){
                        index++;
                        continue;
                    }
                    //A Second Quote mark has been found
                    if(CSVLine.charAt(index) == '\"'){
                        break;
                    }
                }
            }
            // Handling a comma
            else if(CSVLine.charAt(index) == ','){
                // Cell starts with the first character and ends the character before the comma
                String cell = CSVLine.substring(0,index);
                CSVLine = CSVLine.substring(index + 1);
                // the negative 1 will roll over into 0 for the next iteration of the loop
                index = -1;
                arr.add(cell);
            }

        }
        // Handling hitting the end of input
        arr.add(CSVLine);

        // Return Statement
        return arr;
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

