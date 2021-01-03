package com.qbielka.dinazeng.choose_your_own_adventure.model;

import com.google.gson.Gson;

public class GameState {

    // Game information
    private int currentDatabaseStoryKey;

    public int getCurrentDatabaseStoryKey() {
        return currentDatabaseStoryKey;
    }

    public void setCurrentDatabaseStoryKey(int currentDatabaseStoryKey) {
        this.currentDatabaseStoryKey = currentDatabaseStoryKey;
    }

    // Fields that change from game to game
    private int grass;
    private int twigs;
    private int flint;
    private int time;

    public int getGrass() {
        return grass;
    }

    public void setGrass(int grass) {
        this.grass = grass;
    }

    public int getTwigs() {
        return twigs;
    }

    public void setTwigs(int twigs) {
        this.twigs = twigs;
    }

    public int getFlint() {
        return flint;
    }

    public void setFlint(int flint) {
        this.flint = flint;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
