package com.qbielka.dinazeng.choose_your_own_adventure.model;

import android.content.Context;

import com.qbielka.dinazeng.choose_your_own_adventure.database.StoryDatabaseHelper;
import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;



public class StoryModel {
    private StoryDatabaseHelper db;
    private Story thisStory;

    public StoryModel(int key, Context context){
        db = new StoryDatabaseHelper(context);
        thisStory = db.getStory(key);
    }

    /**
     * This takes in the number of the button that was pushed and triggers its effect
     * @param num the number of the button that was pushed starting at 0
     */
    public void buttonNPushed(int num, Context context){


        // Change the gameState with new effects
        GameState origin = Singleton.getInstance(context).gameState;
        GameState change = thisStory.getButtonArr().get(num).getButtonEffects();

        Singleton.getInstance(context).gameState = GameState.GameStateAddition(origin, change);

        // change the unit of story we are on
        int nextKey =  thisStory.getButtonArr().get(num).getButtonKey();
        thisStory = db.getStory(nextKey);
        Singleton.getInstance(context).gameState.setCurrentDatabaseStoryKey(nextKey);
        Singleton.saveGame(context);

    }

    /**
     * this is a function to get the next piece of the story for other classes to call.
     * @return it returns a StoryPiece for the UI to use.
     */
    public StoryPiece getNextStory(){
        return new StoryPiece(thisStory);
    }

}
