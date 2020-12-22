package com.example.choose_your_own_adventure.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;

public class Singleton {
    // final variables are keys to access SharedPreferences
    private static final String GAME_STATE_CODE = "GameState";
    private static final String SHARED_PREFERENCES_ACCESS = "ChooseYourOwnAdventureAccess";

    // suppresses the memory Leak issue because this is a singleton
    @SuppressLint("StaticFieldLeak")
    private static Singleton instance = null;

    // private variables to access a json serializer library and the main app's context
    private final Gson gson;
    private final Context context;

    //public member data
    public GameState gameState;

    private Singleton(Context appContext){
        //setup variables
        context = appContext;
        gson = new Gson();

        // load in last save data
        SharedPreferences savedGame = context.getSharedPreferences(SHARED_PREFERENCES_ACCESS, Context.MODE_PRIVATE);
        String saveFile = savedGame.getString(GAME_STATE_CODE, "");

        // turn save data into a current game or start a new game if no save data exists
        if(saveFile.isEmpty()){
            gameState = new GameState();
        }else {
            gameState = gson.fromJson(saveFile, GameState.class);
        }

    }

    public void SaveGame(){
        // get save data from the current game
        String saveFile = gson.toJson(gameState);

        // make a saveFile in sharedPreferences
        SharedPreferences savedGame = context.getSharedPreferences(SHARED_PREFERENCES_ACCESS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = savedGame.edit();
        editor.putString(GAME_STATE_CODE, saveFile);
        editor.apply();
    }

    // the getInstance method that allows other piece of the code to see this
    public static Singleton getInstance(Context context){
        if(instance == null){
            instance = new Singleton(context);
        }

        return instance;
    }

}
