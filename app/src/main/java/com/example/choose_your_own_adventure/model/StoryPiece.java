package com.example.choose_your_own_adventure.model;

import java.util.ArrayList;

/**
 * StoryPiece is the textual content of a single frame of the story.
 *  It holds the list of options as well as the explanation of what just happened as well as what is happening now
 */
public class StoryPiece {

    private String story;
    private ArrayList<String> buttons;

    /**
     * This is the constructor for StoryPiece it required
     * @param story is the text that will be shown in the UI that is not a button
     */
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
