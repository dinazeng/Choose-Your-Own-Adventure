package com.example.choose_your_own_adventure.model;

import java.util.ArrayList;

public class StoryPiece {

    private String story;
    private ArrayList<String> buttons;

    public StoryPiece(String story){
        this.story = story;
    }

    /**
     * needs the text of a button
     * @return will return the current number of buttons registered
     */
    public int addButton(String buttonText) {
        if(buttonText == null){
            return buttons.size();
        }
        buttons.add(buttonText);
        return buttons.size();
    }

    public String getStory() {
        return story;
    }

    public ArrayList<String> getButtons() {
        return buttons;
    }
}
