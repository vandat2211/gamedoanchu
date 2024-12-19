package com.example.gamedoanchu.Doanchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
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
import com.example.gamedoanchu.Model.GameModels;
import com.example.gamedoanchu.Object.cauhoi;
import com.example.gamedoanchu.R;
import com.example.gamedoanchu.data_local.DataLocalManager;

import java.util.ArrayList;
import java.util.Random;

public class Choigame extends AppCompatActivity {
    MediaPlayer dung,sai,gophim;
    Animation d,e,f;
    GameModels models;
    cauhoi caudo;
    private String dapan="soctrang";
ArrayList<String> arrayListtraloi;
GridView gridViewctl;
ImageView imganh;
TextView tvdiem,tvcau,tvtb;
int index=0;
    ArrayList<String> arrayListda;
    GridView gridViewda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choigame);
        init();
        amhxa();
        setOnclick();
        hiencaudo();
        hiencaudoluu();


    }
    private void amhxa(){
        gridViewctl=findViewById(R.id.grcautraloi);
        gridViewda=findViewById(R.id.grdapan);
        imganh=findViewById(R.id.imganh);
        tvdiem=findViewById(R.id.tvdiem);
        tvtb=findViewById(R.id.tb);
        tvcau=findViewById(R.id.tvcau);
        d = AnimationUtils.loadAnimation(this, R.anim.amin_hienra);
        e = AnimationUtils.loadAnimation(this, R.anim.amin_dichuyen);
        f = AnimationUtils.loadAnimation(this, R.anim.amin_phongto);
        dung=MediaPlayer.create(Choigame.this,R.raw.votayy);
        sai=MediaPlayer.create(Choigame.this,R.raw.sai);
        gophim=MediaPlayer.create(Choigame.this,R.raw.gophimp);
    }
    private void init(){
        models=new GameModels(this);
        arrayListtraloi=new ArrayList<>();

        arrayListda=new ArrayList<>();

    }
    private void hiencaudo() {
        caudo = models.laycauhoi();
        dapan = caudo.dapan;
        Data();
        hienthi();
        hienthida();
        Glide.with(this)
                .load(caudo.anh)
                .into(imganh);
        models.laytt();
        tvdiem.setText(models.nguoichoi.tien + " $");
        tvcau.setText(caudo.ten);
        gridViewda.startAnimation(e);
        gridViewctl.startAnimation(d);
    }
    private void hiencaudoluu() {
        cauhoi hoi= DataLocalManager.getcauhois();
        if(hoi != null) {
            dapan=hoi.getDapan();
            Data();
            hienthi();
            hienthida();
            tvcau.setText(hoi.getTen());
            Glide.with(this)
                    .load(hoi.getAnh())
                    .into(imganh);
            models.laytt();
            tvdiem.setText(models.nguoichoi.tien+" $");
                caudo=models.laycau();
            gridViewda.startAnimation(e);
            gridViewctl.startAnimation(d);
            }
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
                tvtb.setVisibility(View.INVISIBLE);
                String s= (String) adapterView.getItemAtPosition(i);
                if(!s.isEmpty() && index<arrayListtraloi.size()){
                    for(int i1=0;i1<arrayListtraloi.size();i1++){
                        if(arrayListtraloi.get(i1).isEmpty()){
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
                tvtb.setVisibility(View.INVISIBLE);
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
            s = s + sl;
        }
        s=s.toUpperCase();
         Intent intent1=getIntent();
         String key=intent1.getStringExtra("11");
             if (s.equals(dapan.toUpperCase())) {
                 Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
                 dung.start();
                 models.laytt();
                 models.nguoichoi.tien = models.nguoichoi.tien + 10;
                 tvdiem.startAnimation(f);
                 models.luutt();
                 DataLocalManager.setcauhois(caudo);
                 hiencaudo();
                 hiencaudoluu();

             }
             if (s.length() == dapan.length()) {
                 if (!s.equals(dapan.toUpperCase())) {
                     sai.start();
                     models.laytt();
                     models.nguoichoi.tien = models.nguoichoi.tien - 15;
                     tvdiem.startAnimation(f);
                     if(models.nguoichoi.tien<0)  models.nguoichoi.tien=0;
                     tvdiem.setText(models.nguoichoi.tien+"");
                     models.luutt();
                 }
             }



     }

    public void mogoiy(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        models.luutt();
        if (models.nguoichoi.tien < 5) {
            tvtb.setVisibility(View.VISIBLE);
            tvtb.startAnimation(e);
            tvtb.setText("khong du tien mo goi y");
            return;
        }
        int id = -1;
        for (int i = 0; i < arrayListtraloi.size(); i++) {
            if (arrayListtraloi.get(i).length() == 0) {
                id = i;
                break;
            }
        }
        if (id == -1)
        {

            for (int i = 0; i < arrayListtraloi.size(); i++) {
                String s = dapan.toUpperCase().charAt(i) + "";
                if (!arrayListtraloi.get(i).toUpperCase().equals(s)) {
                    id = i;
                    break;

                }

            }
            for (int i = 0; i < arrayListda.size(); i++) {
                if (arrayListda.get(i).length() == 0) {
                    arrayListda.set(i, arrayListtraloi.get(id));
                    break;
                }
            }
        }
            String goiy = "" + dapan.charAt(id);
            goiy = goiy.toUpperCase();
//            for (int i = 0; i < arrayListtraloi.size(); i++) {
//                if (arrayListtraloi.get(i).toUpperCase().equals(goiy)) {
//                    arrayListtraloi.set(i,"");
//                    break;
//                }
//            }

            for (int i = 0; i < arrayListda.size(); i++) {
                if (goiy.equals(arrayListda.get(i))) {
                    arrayListda.set(i, "");
                    break;
                }
            }

            arrayListtraloi.set(id, goiy);
            hienthi();
            hienthida();
            models.nguoichoi.tien = models.nguoichoi.tien - 5;
            models.luutt();
            tvdiem.setText(models.nguoichoi.tien + " $");
        }


    public void doicauhoi(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        models.luutt();
        if (models.nguoichoi.tien < 15) {
            tvtb.setVisibility(View.VISIBLE);
            tvtb.startAnimation(d);
            tvtb.setText("khong du tien doi cau hoi");
            return;
        }
        models.nguoichoi.tien = models.nguoichoi.tien - 15;
        models.luutt();
        tvdiem.setText(models.nguoichoi.tien + " $");
        hiencaudo();

    }

    public void trangchu(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        gophim.start();
        startActivity(new Intent(this,MainActivity.class));
    }
}

