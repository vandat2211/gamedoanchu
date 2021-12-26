package com.example.gamedoanchu.data_local;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreferences {
    public static final String ok="ok";
    private Context context;
    public  MySharePreferences(Context context){this.context=context;}
    public void putStringValue(String key,String value){
        SharedPreferences sharedPreferences=context.getSharedPreferences(ok,context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }
    public String getStringValue(String key){
        SharedPreferences sharedPreferences=context.getSharedPreferences(ok,context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}
