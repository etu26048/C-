package com.henallux.firstapp;

/**
 * Created by dark- on 25/09/2016.
 */

public class FirstApp extends android.app.Application {

    private int nbClick = 0;

    public void onCreate()
    {
        super.onCreate();
    }
    public int getNbClick(){return nbClick++;}
}
