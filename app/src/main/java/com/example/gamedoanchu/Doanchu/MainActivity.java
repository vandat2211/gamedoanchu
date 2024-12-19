package com.example.gamedoanchu.Doanchu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.gamedoanchu.Api.Getcauhoi;
//import com.example.gamedoanchu.Draw.MainActivity_vehinh;
import com.example.gamedoanchu.Object.cauhoi;
import com.example.gamedoanchu.R;
import com.example.gamedoanchu.data_local.DataLocalManager;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mysong,gophim;
    Button bt,bt2,bt3;
    ImageView imageView1,imageView2;
    Animation a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.nut);
        bt2=findViewById(R.id.nut2);
        bt3=findViewById(R.id.nut3);
        mysong=MediaPlayer.create(MainActivity.this,R.raw.nen);
        gophim=MediaPlayer.create(MainActivity.this,R.raw.gophimp);
        mysong.start();
//        new Getcauhoi().execute();
        a = AnimationUtils.loadAnimation(this, R.anim.amin_right);
        b = AnimationUtils.loadAnimation(this, R.anim.amin_ok);
        c = AnimationUtils.loadAnimation(this, R.anim.amin_left);
        imageView1 = findViewById(R.id.imgxb);
        imageView1.startAnimation(a);
        imageView2=findViewById(R.id.imgxbv);
        imageView2.startAnimation(c);
       bt.startAnimation(b);
       bt2.startAnimation(b);
       bt3.startAnimation(b);

    }
    private void setDialogOutGame() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_stop_game);
        TextView tvAnswer = (TextView) dialog.findViewById(R.id.tv_dialog_stop);
        tvAnswer.setText("Bạn có muốn thoát trò chơi không ?");
        Button btnOKStop = (Button) dialog.findViewById(R.id.btn_ok_stop_game);
        Button btnCancelStop = (Button) dialog.findViewById(R.id.btn_cancel_stop_game);
        btnOKStop.setText("OK");
        btnCancelStop.setText("Chơi tiếp!");

        btnOKStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishAndRemoveTask();
            }
        });

        btnCancelStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();
    }
    public void vaogame(View view) {
        gophim.start();
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        cauhoi hoi= DataLocalManager.getcauhois();
        if(hoi != null) {
            startActivity(new Intent(this, Choigame.class));
            mysong.release();
        }else{
            startActivity(new Intent(this, Choigame.class));
        }
        finish();
    }

//    public void ve(View view) {
//        gophim.start();
//        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
//        startActivity(new Intent(this, MainActivity_vehinh.class));
//        mysong.release();
//        finish();
//    }

    public void vaosieutoc(View view) {
        mysong.release();
        startActivity(new Intent(this, dhbc_sieutoc.class));
        finish();
    }
    public void thoat(View view) {
        mysong.release();
        gophim.start();
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
       setDialogOutGame();
    }
}