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

    //todo needs to change whenever Button Does more than just ints

    // Fields that change from game to game
    private int grass;
    private int twigs;
    private int flint;
    private int time;


    public static boolean isActionValid(GameState g1, GameState g2){
        GameState toCheck = GameStateAddition(g1, g2);

        boolean isTwigs = toCheck.twigs >= 0;
        boolean isGrass = toCheck.grass >= 0;
        boolean isTime = toCheck.time >= 0;
        boolean isFlint = toCheck.flint >= 0;

        return isFlint && isTime && isGrass && isTwigs;
    }

    public static GameState GameStateAddition(GameState g1, GameState g2){
        GameState newGameState = new GameState();
        newGameState.setTwigs(g1.twigs + g1.twigs);
        newGameState.setFlint(g1.flint + g2.flint);
        newGameState.setTime(g1.time + g2.time);
        newGameState.setGrass(g1.grass + g2.grass);

        return newGameState;
    }

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
