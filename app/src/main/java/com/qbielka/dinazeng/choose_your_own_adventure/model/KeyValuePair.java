package com.qbielka.dinazeng.choose_your_own_adventure.model;

public class KeyValuePair {
    int value;
    String key;

    public KeyValuePair(int value, String key) {
        this.value = value;
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
