package com.example.choose_your_own_adventure.model;

import java.util.ArrayList;

//TODO this class
public class StoryModel {

    private int storyBoard = 0;
    public void button1Pushed(){}

    public void button2Pushed(){}

    public void button3Pushed(){}

    public void button4Pushed(){}

    public StoryPiece getNextStory(){

        StoryPiece storyPiece = new StoryPiece("Default Story Piece");
        storyPiece.addButton("Default Button "+(1+storyBoard));
        storyPiece.addButton("Default Button "+(2+storyBoard));
        storyPiece.addButton("Default Button "+(3+storyBoard));
        storyBoard += 3;
        return storyPiece;
    }

}
