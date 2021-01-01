package com.qbielka.dinazeng.choose_your_own_adventure.model;

import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;

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
     * @param story is the storty fetched from the database
     */
    public StoryPiece(Story story){
        this.story = story.getStory();
        this.buttons = new ArrayList<>();
        if(story.getNumButtons() > 0){
            buttons.add(story.getButton1Text());
        }
        if(story.getNumButtons() > 1){
            buttons.add(story.getButton2Text());
        }
        if(story.getNumButtons() > 2){
            buttons.add(story.getButton3Text());
        }
        if(story.getNumButtons() > 3){
            buttons.add(story.getButton4Text());
        }


    }


    public String getStory() {
        return story;
    }

    public ArrayList<String> getButtons() {
        return buttons;
    }
}
