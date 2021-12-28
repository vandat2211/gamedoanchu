package com.example.gamedoanchu.Doanchu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gamedoanchu.Model.GameModels2;

import com.example.gamedoanchu.R;

public class dhbc_sieutoc extends AppCompatActivity {
    MediaPlayer gophim;
    TextView tvdiem2,tvdiem3,tvtime;
    ImageView a1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhbc_sieutoc);
        anhxa();
        Intent intent=getIntent();
        String dung=intent.getStringExtra("tldung");
        String sai=intent.getStringExtra("tlsai");
            if(dung==null ) {
                tvdiem2.setText("$$$");
            }
            else {
                tvdiem2.setText(dung +" $");
                tvdiem3.setVisibility(View.INVISIBLE);
            }
             if(sai==null ) {
                 tvdiem3.setText("$$$");
             }
            else {
                 tvdiem3.setText(sai + " $");
                 tvdiem2.setVisibility(View.INVISIBLE);
             }



    }
    public void anhxa(){
        a1=findViewById(R.id.a1);

        tvdiem2=findViewById(R.id.tvdiem2);
        tvdiem3=findViewById(R.id.tvdiem3);
        gophim=MediaPlayer.create(dhbc_sieutoc.this,R.raw.gophimp);
    }
public void huongdan(View view){

}

    public void hinh1(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
      Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
      startActivity(intent1);
    }
    public void hinh2(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh3(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh4(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh5(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh6(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh7(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh8(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh9(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh10(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh11(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh12(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh13(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh14(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh15(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh16(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh17(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh18(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh19(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh20(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh21(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh22(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh23(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh24(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void hinh25(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        Intent intent1 =new Intent(dhbc_sieutoc.this,Choi_sieu_toc.class);
        startActivity(intent1);
    }
    public void trangchu(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        startActivity(new Intent(this,MainActivity.class));
    }
}