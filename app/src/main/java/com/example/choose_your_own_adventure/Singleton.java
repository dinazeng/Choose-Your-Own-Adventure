package com.example.choose_your_own_adventure;

public class Singleton {
    private Singleton instance = null;

    //public member data


    private Singleton(){}

    public Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }

}
