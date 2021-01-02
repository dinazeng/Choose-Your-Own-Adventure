package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

public class Button {
    int buttonKey;
    String buttonText;

    public Button(int buttonKey, String buttonText) {
        this.buttonKey = buttonKey;
        this.buttonText = buttonText;
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
}
