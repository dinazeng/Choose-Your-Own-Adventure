package com.example.choose_your_own_adventure.model;

import com.google.gson.Gson;

public class GameState {

    private int grassCount;
    private int twigCount;
    private int flintCount;

    /**
     * default constructor to create a new game
     */
    public GameState(){
        this.grassCount = 0;
        this.twigCount = 0;
        this.flintCount = 0;
    }

    /**
     * constructor to rebuild the old game from information
     */
    public GameState(int grassCount, int twigCount, int flintCount) {
        this.grassCount = grassCount;
        this.twigCount = twigCount;
        this.flintCount = flintCount;
    }

    // Getters and Setters
    public int getGrassCount() {
        return grassCount;
    }

    public void setGrassCount(int grassCount) {
        this.grassCount = grassCount;
    }

    public int getTwigCount() {
        return twigCount;
    }

    public void setTwigCount(int twigCount) {
        this.twigCount = twigCount;
    }

    public int getFlintCount() {
        return flintCount;
    }

    public void setFlintCount(int flintCount) {
        this.flintCount = flintCount;
    }
}
