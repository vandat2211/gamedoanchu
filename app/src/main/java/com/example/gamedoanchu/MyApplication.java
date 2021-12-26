package com.example.gamedoanchu;

import android.app.Application;

import com.example.gamedoanchu.data_local.DataLocalManager;

public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }
}
