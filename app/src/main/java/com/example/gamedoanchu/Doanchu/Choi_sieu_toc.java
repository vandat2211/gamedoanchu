package com.example.gamedoanchu.Doanchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gamedoanchu.Adapter.DapanAdapter;
import com.example.gamedoanchu.Model.GameModels2;
import com.example.gamedoanchu.Object.cauhoi;
import com.example.gamedoanchu.R;

import java.util.ArrayList;
import java.util.Random;

public class Choi_sieu_toc extends AppCompatActivity {
    MediaPlayer dung,sai,gophim;
    Animation d,e,f;
    GameModels2 models;
    cauhoi caudo;
    TextView tvdiem,tvtime;
    private String dapan="soctrang";
    ArrayList<String> arrayListtraloi;
    GridView gridViewctl;
    ImageView imganh;
    int index=0;
    ArrayList<String> arrayListda;
    GridView gridViewda;
    public  int timetong=10;
    public  int timechay=timetong*1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_sieu_toc);
        init();
        amhxa();
        setOnclick();
        laycau();
        Time();
    }
    private void amhxa(){
        gridViewctl=findViewById(R.id.grcautraloi);
        gridViewda=findViewById(R.id.grdapan);
        imganh=findViewById(R.id.imganh);
        tvdiem=findViewById(R.id.tvdiemm);
        tvtime=findViewById(R.id.tvtimem);
        d = AnimationUtils.loadAnimation(this, R.anim.amin_hienra);
        e = AnimationUtils.loadAnimation(this, R.anim.amin_dichuyen);
        f = AnimationUtils.loadAnimation(this, R.anim.amin_phongto);
        dung=MediaPlayer.create(Choi_sieu_toc.this,R.raw.votayy);
        sai=MediaPlayer.create(Choi_sieu_toc.this,R.raw.sai);
        gophim=MediaPlayer.create(Choi_sieu_toc.this,R.raw.gophimp);
    }
    private void Time(){
        new CountDownTimer(timetong*1000,1){

            @Override
            public void onTick(long l) {
                timechay= (int) l;
                if(timechay>=0){
                    int sogiay=timechay/1000;
                    int minigiay=timechay%1000/10;
                    String times= sogiay+":"+minigiay;
                    tvtime.setText(times);
                }
                else {
                    tvtime.setText("00:00");
                }

            }

            @Override
            public void onFinish() {
                tvtime.setText("00:00");
                hetgio();
            }
        }.start();
    }
    private void hetgio(){
        models.laytt();
        models.nguoichoi.tien = models.nguoichoi.tien - 5;
        models.luutt();
        if(models.nguoichoi.tien<0) {
            models.nguoichoi.tien=0;
            models.luutt();}
        Intent intent = new Intent(Choi_sieu_toc.this, dhbc_sieutoc.class);
        intent.putExtra("tlsai", models.nguoichoi.tien + "");
        startActivity(intent);


    }
    private void init(){
        models= new GameModels2(this);
        arrayListtraloi=new ArrayList<>();

        arrayListda=new ArrayList<>();

    }
    private void laycau() {
        caudo = models.laycau();
        dapan = caudo.dapan;
        Data();
        hienthi();
        hienthida();
        Glide.with(this)
                .load(caudo.anh)
                .into(imganh);
        models.laytt();
        tvdiem.setText(models.nguoichoi.tien + " $");
        gridViewda.startAnimation(e);
        gridViewctl.startAnimation(d);
    }

    private void hienthi(){
        if(arrayListtraloi.size()<=9) gridViewctl.setNumColumns(arrayListtraloi.size());
        else gridViewctl.setNumColumns(arrayListtraloi.size()/2);
        gridViewctl.setAdapter(new DapanAdapter(this,0,arrayListtraloi));
    }
    private void hienthida(){
        if(arrayListtraloi.size()<=9) gridViewda.setNumColumns(arrayListda.size()/2);
        else gridViewda.setNumColumns(arrayListda.size()/3);
        gridViewda.setAdapter(new DapanAdapter(this,0,arrayListda));
    }
    private void setOnclick(){
        gridViewda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gophim.start();
                String s= (String) adapterView.getItemAtPosition(i);
                if(s.length()!=0 && index<arrayListtraloi.size()){
                    for(int i1=0;i1<arrayListtraloi.size();i1++){
                        if(arrayListtraloi.get(i1).length()==0){
                            index=i1;
                            break;
                        }
                    }
                    arrayListda.set(i,"");
                    arrayListtraloi.set(index,s);
                    index++;
                    hienthi();
                    hienthida();
                    checkwin();
                }
            }
        });
        gridViewctl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gophim.start();
                String s= (String) adapterView.getItemAtPosition(i);
                if(s.length()!=0){
                    index=i;
                    arrayListtraloi.set(i,"");
                    for(int i1=0;i1<arrayListda.size();i1++){
                        if(arrayListda.get(i1).length()==0){
                            arrayListda.set(i1,s);
                            break;
                        }
                    }
                    hienthi();
                    hienthida();
                }
            }
        });
    }
    private void Data(){
        index=0;
        arrayListtraloi.clear();
        arrayListda.clear();
        Random r=new Random();
        for(int i=0;i<dapan.length();i++){
            arrayListtraloi.add("");
            String s=""+ (char)(r.nextInt(26)+65);
            arrayListda.add(s);
            String s1=""+ (char)(r.nextInt(26)+65);
            arrayListda.add(s1);
        }
        for(int i=0;i<dapan.length();i++) {
            String s=""+ dapan.charAt(i);
            arrayListda.set(i,s.toUpperCase());
        }
        for (int i=0;i<arrayListda.size();i++){
            String s=arrayListda.get(i);
            int vt=r.nextInt(arrayListda.size());
            arrayListda.set(i,arrayListda.get(vt));
            arrayListda.set(vt,s);
        }
    }
    private void checkwin(){
        String s="";
        for(String sl:arrayListtraloi){
            s=s+sl;
        }
        s=s.toUpperCase();
        if (s.equals(dapan.toUpperCase())) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            dung.start();
            models.laytt();
            models.nguoichoi.tien = models.nguoichoi.tien + 10;
            models.luutt();
           Intent intent =new Intent(Choi_sieu_toc.this,dhbc_sieutoc.class);
           intent.putExtra("tldung",models.nguoichoi.tien+"");
           startActivity(intent);


        }
        if (s.length() == dapan.length()) {
            if (!s.equals(dapan.toUpperCase())) {
                sai.start();
                models.laytt();
                models.nguoichoi.tien = models.nguoichoi.tien - 20;
                models.luutt();
                if(models.nguoichoi.tien<0) {
                    models.nguoichoi.tien=0;
                    models.luutt();
                }
                    Intent intent = new Intent(Choi_sieu_toc.this, dhbc_sieutoc.class);
                    intent.putExtra("tlsai", models.nguoichoi.tien + "");
                    startActivity(intent);

            }
        }
    }

}

