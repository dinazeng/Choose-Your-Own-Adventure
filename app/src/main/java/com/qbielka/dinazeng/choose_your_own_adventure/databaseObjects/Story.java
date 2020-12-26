package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

public class Story {

    static int nextID = 1;

    int id;
    String story;
    int numButtons;

    String button1Text;
    int button1NextState;

    String button2Text;
    int button2NextState;

    String button3Text;
    int button3NextState;

    String button4Text;
    int button4NextState;



    private void setID(){
        id = nextID;
        nextID++;
    }
}
