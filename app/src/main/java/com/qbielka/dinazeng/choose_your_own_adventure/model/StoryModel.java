package com.qbielka.dinazeng.choose_your_own_adventure.model;

import android.content.Context;

import com.qbielka.dinazeng.choose_your_own_adventure.database.StoryDatabaseHelper;
import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;

import java.security.PublicKey;
import java.util.ArrayList;

//TODO this class
public class StoryModel {
    private StoryDatabaseHelper db;
    private Story thisStory;

    public StoryModel(int key, Context context){
        db = new StoryDatabaseHelper(context);
        thisStory = db.getStory(key);
    }

    public void button1Pushed(){
        int nextKey =  thisStory.getButton1NextState();
        thisStory = db.getStory(nextKey);
        getNextStory();
    }

    public void button2Pushed(){
        int nextKey =  thisStory.getButton2NextState();
        thisStory = db.getStory(nextKey);
        getNextStory();
    }

    public void button3Pushed(){
        int nextKey =  thisStory.getButton3NextState();
        thisStory = db.getStory(nextKey);
        getNextStory();
    }

    public void button4Pushed(){
        int nextKey =  thisStory.getButton4NextState();
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
