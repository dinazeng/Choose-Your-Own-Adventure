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
     * @param num
     */
    public void buttonNPushed(int num){
        // Buttons start numbered at 1 however the array starts them at 0
        num = num -1;
        int nextKey =  thisStory.getButtonArr().get(num).getButtonKey();
        thisStory = db.getStory(nextKey);
        getNextStory();
    }

    /**
     * this is a function to get the next piece of the story for other classes to call.
     * @return it returns a StoryPiece for the UI to use.
     */
    public StoryPiece getNextStory(){
        return new StoryPiece(thisStory);
    }

}
