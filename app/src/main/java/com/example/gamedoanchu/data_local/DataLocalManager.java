package com.example.gamedoanchu.data_local;

import android.content.Context;

import com.example.gamedoanchu.Object.cauhoi;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataLocalManager {
    private static final String caucauhoi = "caucauhoi";
    private static final String listcauhoi = "listcauhoi";
    private static DataLocalManager instance;
    private MySharePreferences mySharePreferences;
    public static void init(Context context){
        instance=new DataLocalManager();
        instance.mySharePreferences=new MySharePreferences(context);
    }
    public static DataLocalManager getInstance(){
        if(instance==null){
            instance=new DataLocalManager();
        }
        return instance;
    }
    public static void setcauhois(cauhoi hoi){
        Gson gson=new Gson() ;
        String gsoncauhoi=gson.toJson(hoi);
        DataLocalManager.getInstance().mySharePreferences.putStringValue(caucauhoi,gsoncauhoi);
    }
    public static cauhoi getcauhois(){
        String gsoncauhois=DataLocalManager.getInstance().mySharePreferences.getStringValue(caucauhoi);
        Gson gson=new Gson();
        cauhoi hoi=gson.fromJson(gsoncauhois,cauhoi.class);
        return hoi;
    }
//    public static void setlistch(List<cauhoi> listch ){
//        Gson gson=new Gson() ;
//       JsonArray jsonArray= gson.toJsonTree(listch).getAsJsonArray();
//       String strjsonarray =jsonArray.toString();
//       DataLocalManager.getInstance().mySharePreferences.putStringValue(listcauhoi,strjsonarray);
//    }
//    public static List<cauhoi> getlistcauhoi(){
//        String strjsonarray=DataLocalManager.getInstance().mySharePreferences.getStringValue(listcauhoi);
//        List<cauhoi> listch=new ArrayList<>();
//        try {
//            JSONArray jsonArray=new JSONArray(strjsonarray);
//            JSONObject jsonObject;
//            cauhoi hoi;
//            Gson gson=new Gson();
//            for(int i=0;i<jsonArray.length();i++){
//                jsonObject=jsonArray.getJSONObject(i);
//                hoi=gson.fromJson(jsonObject.toString(),cauhoi.class);
//                listch.add(hoi);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return listch;
//    }
}
