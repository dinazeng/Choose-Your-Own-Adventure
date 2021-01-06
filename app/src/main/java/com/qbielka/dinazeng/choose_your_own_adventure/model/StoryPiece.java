package com.qbielka.dinazeng.choose_your_own_adventure.model;

import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Button;
import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;

import java.util.ArrayList;

/**
 * StoryPiece is the textual content of a single frame of the story.
 *  It holds the list of options as well as the explanation of what just happened as well as what is happening now
 */
public class StoryPiece {

    private String story;
    //TODO replace buttonEffects with a Gamestate
    private ArrayList<Button> buttons;

    /**
     * This is the constructor for StoryPiece it required
     * @param story is the storty fetched from the database
     */
    public StoryPiece(Story story){
        this.story = story.getStory();
        this.buttons = new ArrayList<>();
        this.buttons.addAll(story.getButtonArr());
    }


    public String getStory() {
        return story;
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }

}
