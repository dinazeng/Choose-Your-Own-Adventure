package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

import com.google.gson.Gson;
import com.qbielka.dinazeng.choose_your_own_adventure.model.GameState;
import com.qbielka.dinazeng.choose_your_own_adventure.model.KeyValuePair;

import java.util.ArrayList;

public class Button {
    int buttonKey;
    GameState gameStateButtonEffects;
    String buttonText;
    String stringButtonEffects;

    public Button(int buttonKey, String buttonText, String buttonEffects) {
        setButtonKey(buttonKey);
        setButtonText(buttonText);
        setButtonEffects(buttonEffects);
    }

    public int getButtonKey() {
        return buttonKey;
    }

    public void setButtonKey(int buttonKey) {
        this.buttonKey = buttonKey;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public GameState getButtonEffects() {
        return gameStateButtonEffects;
    }

    public String getStringButtonEffects() {
        return stringButtonEffects;
    }


    //todo needs to change whenever GameState Does more than just ints
    public void setButtonEffects(String buttonEffects) {
        this.stringButtonEffects = buttonEffects;

        // get the keyValuePair list of the button Effects
        ArrayList <String> buttonEffectsList = splitButtonEffects(buttonEffects);
        ArrayList <KeyValuePair> keyPairList = new ArrayList<>();
        for (int n = 0; n < buttonEffectsList.size(); n++){
            // do a nullcheck for invalid pairs
            KeyValuePair pair = toPair(buttonEffectsList.get(n));
            if(pair != null) {
                keyPairList.add(pair);
            }
        }


        // if there are no button effects make a default gameState
        if(keyPairList.size() == 0) {
            gameStateButtonEffects = new GameState();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (KeyValuePair keyValuePair: keyPairList) {
            stringBuilder.append("\"");
            stringBuilder.append(keyValuePair.getKey());
            stringBuilder.append("\":");
            stringBuilder.append(keyValuePair.getValue());
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("}");

        Gson gson = new Gson ();
        this.gameStateButtonEffects = gson.fromJson(stringBuilder.toString(), GameState.class);
    }

    public static ArrayList<String> splitButtonEffects (String buttonEffectList){
        ArrayList<String> buttonEffects = new ArrayList<>();
        if (buttonEffectList == null || buttonEffectList.length() == 0){
            return buttonEffects;
        }
        for (int n = 1; n < buttonEffectList.length(); n++) {
            if (buttonEffectList.charAt(n) == '+' || buttonEffectList.charAt(n) == '-') {
                String buttonEffect = buttonEffectList.substring(0, n);
                buttonEffects.add(buttonEffect);
                buttonEffectList = buttonEffectList.substring(n);
                n = 1;
            }
        }
        buttonEffects.add(buttonEffectList);
        return buttonEffects;
    }

    /**
     *
     * @param buttonEffect the string that should be input from the csv + or - followed by a number followed by a variable name
     * @return null if the string was not properly formatted or a KeyValuePair for use in making JSON object later
     */
    public KeyValuePair toPair (String buttonEffect){
        try {
            //finds the operator of the button effect
            int operator;
            if (buttonEffect.charAt(0) == '+') {
                operator = 1;
            } else if (buttonEffect.charAt(0) == '-') {
                operator = -1;
            } else {
                operator = 0;
            }

            //finds the integer value of button effect
            StringBuilder counter = new StringBuilder();
            for (int n = 1; n < buttonEffect.length(); n++) {
                if (buttonEffect.charAt(n) >= '0' && buttonEffect.charAt(n) <= '9') {
                    counter.append(buttonEffect.charAt(n));
                }
            }
            int value = Integer.parseInt(counter.toString()) * operator;

            //finds the string of the button effect
            String remainder = buttonEffect.substring(counter.length() + 1);

            return new KeyValuePair(value, remainder);
        }catch (Exception e){
            return null;
        }
    }
}
