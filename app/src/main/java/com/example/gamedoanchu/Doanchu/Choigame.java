package com.example.gamedoanchu.Doanchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gamedoanchu.Adapter.DapanAdapter;
import com.example.gamedoanchu.Model.GameModels;
import com.example.gamedoanchu.Object.cauhoi;
import com.example.gamedoanchu.R;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Choigame extends AppCompatActivity {
    GameModels models;
    cauhoi caudo;
    private String dapan="soctrang";
ArrayList<String> arrayListtraloi;
GridView gridViewctl;
ImageView imganh;
TextView tvdiem;
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
    }
    private void amhxa(){
        gridViewctl=findViewById(R.id.grcautraloi);
        gridViewda=findViewById(R.id.grdapan);
        imganh=findViewById(R.id.imganh);
        tvdiem=findViewById(R.id.tvdiem);
    }
    private void init(){
        models=new GameModels(this);
        arrayListtraloi=new ArrayList<>();

        arrayListda=new ArrayList<>();

    }
    private void hiencaudo(){
        caudo=models.laycauhoi();
        dapan=caudo.dapan;
        Data();
        hienthi();
        hienthida();
        Glide.with(this)
                .load(caudo.anh)
                .into(imganh);
        models.laytt();
        tvdiem.setText(models.nguoichoi.tien+" $");
    }
    private void hienthi(){
        gridViewctl.setNumColumns(arrayListtraloi.size());
        gridViewctl.setAdapter(new DapanAdapter(this,0,arrayListtraloi));
    }
    private void hienthida(){
        gridViewda.setNumColumns(arrayListda.size()/2);
        gridViewda.setAdapter(new DapanAdapter(this,0,arrayListda));
    }
    private void setOnclick(){
        gridViewda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
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
        if(s.equals(dapan.toUpperCase())){
            Toast.makeText(this,"OK",Toast.LENGTH_SHORT).show();
            models.laytt();
            models.nguoichoi.tien=models.nguoichoi.tien+10;
            models.luutt();
            hiencaudo();
        }
     }

    public void mogoiy(View view) {
        models.luutt();
        if (models.nguoichoi.tien < 5) {
            Toast.makeText(this, "ko du tien mua goi y", Toast.LENGTH_SHORT).show();
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
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
        models.luutt();
        if (models.nguoichoi.tien < 15) {
            Toast.makeText(this, "ko du tien doi cau hoi", Toast.LENGTH_SHORT).show();
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        models.nguoichoi.tien = models.nguoichoi.tien - 15;
        models.luutt();
        tvdiem.setText(models.nguoichoi.tien + " $");
        hiencaudo();
    }
}
