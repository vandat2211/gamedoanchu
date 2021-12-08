package com.example.gamedoanchu.Api;


import android.os.AsyncTask;

import com.example.gamedoanchu.Data;
import com.example.gamedoanchu.Object.cauhoi;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Getcauhoi extends AsyncTask<Void,Void,Void> {
    String data;

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.8/duoihinhbatchu/laycauhoi.php")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            data = responseBody.string();
        } catch (IOException e) {
            data = null;
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (data != null) {
            Data.getData().arraycaudo.clear();
            try {
                JSONArray array = new JSONArray(data);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject o = array.getJSONObject(i);
                    cauhoi ch = new cauhoi();
                    ch.anh = o.getString("anh");
                    ch.ten = o.getString("ten");
                    ch.dapan = o.getString("dapan");
                    Data.getData().arraycaudo.add(ch);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
        }
    }
}
