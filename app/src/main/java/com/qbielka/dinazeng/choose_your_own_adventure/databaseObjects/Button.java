package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

import com.google.gson.Gson;
import com.qbielka.dinazeng.choose_your_own_adventure.model.GameState;
import com.qbielka.dinazeng.choose_your_own_adventure.model.KeyValuePair;

import java.util.ArrayList;

public class Button {
    int buttonKey;
    GameState buttonEffects;
    String buttonText;

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
        return buttonEffects;
    }

    public void setButtonEffects(GameState buttonEffects) {
        this.buttonEffects = buttonEffects;
    }

    public void setButtonEffects(String buttonEffects) {
        ArrayList <String> buttonEffectsList = splitButtonEffects(buttonEffects);
        ArrayList <KeyValuePair> keyPairList = new ArrayList<>();
        for (int n = 0; n < buttonEffectsList.size(); n++){
            keyPairList.add(toPair(buttonEffectsList.get(n)));
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (KeyValuePair keyValuePair: keyPairList) {
            //todo fix tempString (no string concatenation)
            String tempString = "\"" + keyValuePair.getKey() + "\":" + keyValuePair.getValue() + ",";
            stringBuilder.append(tempString);
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("}");

        Gson gson = new Gson ();
        this.buttonEffects = gson.fromJson(stringBuilder.toString(), GameState.class);
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

    public KeyValuePair toPair (String buttonEffect){
        //finds the operator of the button effect
        int operator;
        if (buttonEffect.charAt(0) == '+'){
            operator = 1;
        }
        else if (buttonEffect.charAt(0) == '-'){
            operator = -1;
        }
        else {
            operator = 0;
        }

        //finds the integer value of button effect
        StringBuilder counter = new StringBuilder();
        for (int n = 1; n < buttonEffect.length(); n++){
            if (buttonEffect.charAt(n) >= '0' && buttonEffect.charAt(n) <= '9'){
               counter.append(buttonEffect.charAt(n));
            }
        }
        int value = Integer.parseInt(counter.toString()) * operator;

        //finds the string of the button effect
        String remainder = buttonEffect.substring(counter.length() + 1);

        return new KeyValuePair(value, remainder);
    }
}
