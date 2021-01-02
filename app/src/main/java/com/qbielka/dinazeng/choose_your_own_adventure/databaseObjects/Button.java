package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

public class Button {
    int buttonKey;
    String buttonEffects;
    String buttonText;

    public Button(int buttonKey, String buttonText, String buttonEffects) {
        this.buttonKey = buttonKey;
        this.buttonText = buttonText;
        this.buttonEffects = buttonEffects;
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

    public String getButtonEffects() {
        return buttonEffects;
    }

    public void setButtonEffects(String buttonEffects) {
        this.buttonEffects = buttonEffects;
    }
}
