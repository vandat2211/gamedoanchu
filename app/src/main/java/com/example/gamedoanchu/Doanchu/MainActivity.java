package com.example.gamedoanchu.Doanchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.example.gamedoanchu.Api.Getcauhoi;
import com.example.gamedoanchu.Draw.MainActivity_vehinh;
import com.example.gamedoanchu.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Getcauhoi().execute();
    }

    public void vaogame(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
            startActivity(new Intent(this,Choigame.class));

    }

    public void ve(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        startActivity(new Intent(this, MainActivity_vehinh.class));
    }
}