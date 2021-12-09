package com.example.gamedoanchu.Object;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.material.imageview.ShapeableImageView;

public class Nguoichoi {
    private String namedata="appdata";
    public int tien,cau;
    public String anh;
    public void savett(Context context){
        SharedPreferences settings=context.getSharedPreferences(namedata,0);
        SharedPreferences.Editor editor= settings.edit();
        editor.putInt("tien",tien);

        editor.commit();

    }
    public void gettt(Context context){
        SharedPreferences settings=context.getSharedPreferences(namedata,0);
        tien=settings.getInt("tien",20);
    }
}
