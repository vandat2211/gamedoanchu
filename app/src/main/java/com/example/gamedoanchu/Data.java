package com.example.gamedoanchu;

import androidx.collection.ArraySet;

import com.example.gamedoanchu.Object.cauhoi;

import java.util.ArrayList;

public class Data {
    private static Data data;
    static {
        data=new Data();
    }

    public static Data getData(){
        return data;
    }

  public ArrayList<cauhoi> arraycaudo=new ArrayList<>();
}
