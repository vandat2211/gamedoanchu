package com.example.gamedoanchu.Doanchu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.session.PlaybackState;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gamedoanchu.Api.Getcauhoi;
import com.example.gamedoanchu.Draw.MainActivity_vehinh;
import com.example.gamedoanchu.Object.cauhoi;
import com.example.gamedoanchu.R;
import com.example.gamedoanchu.data_local.DataLocalManager;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mysong;
    Button bt;
    ImageView imageView1,imageView2;
    Animation a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.nut);
        mysong=MediaPlayer.create(MainActivity.this,R.raw.nen);
        mysong.start();
        new Getcauhoi().execute();
        a = AnimationUtils.loadAnimation(this, R.anim.amin_right);
        b = AnimationUtils.loadAnimation(this, R.anim.amin_ok);
        c = AnimationUtils.loadAnimation(this, R.anim.amin_left);
        imageView1 = findViewById(R.id.imgxb);
        imageView1.startAnimation(a);
        imageView2=findViewById(R.id.imgxbv);
        imageView2.startAnimation(c);
       bt.startAnimation(b);
    }

    public void vaogame(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        cauhoi hoi= DataLocalManager.getcauhois();
        if(hoi != null) {
            startActivity(new Intent(this, Choigame.class));
            mysong.release();
        }
        startActivity(new Intent(this, Choigame.class));
    }

    public void ve(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        startActivity(new Intent(this, MainActivity_vehinh.class));
    }
}