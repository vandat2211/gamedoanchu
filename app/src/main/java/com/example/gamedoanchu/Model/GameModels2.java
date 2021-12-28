package com.example.gamedoanchu.Model;

import com.example.gamedoanchu.Data;
import com.example.gamedoanchu.Doanchu.Choi_sieu_toc;
import com.example.gamedoanchu.Doanchu.Choigame;
import com.example.gamedoanchu.Object.cauhoi;
import com.example.gamedoanchu.Object.Nguoichoi;

import java.util.ArrayList;
import java.util.Random;

public class GameModels2 {
    Choi_sieu_toc c;
    ArrayList<cauhoi> arr;
    int causo=0;
    public Nguoichoi nguoichoi;
    public GameModels2(Choi_sieu_toc c) {
        this.c = c;
        nguoichoi=new Nguoichoi();
        CreateData();

    }
    private  void CreateData(){
        arr=new ArrayList<>(Data.getData().arraycaudo);
//        arr.add(new cauhoi("cau 1","nguoisoi","https://scontent.fhan5-6.fna.fbcdn.net/v/t1.15752-9/262025899_1082038795668654_7201057450859186501_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=diY49qChirUAX803Hci&_nc_ht=scontent.fhan5-6.fna&oh=d892323734868d11c2fe0760b6fac159&oe=61D3C148"));
//        arr.add(new cauhoi("cau 2","bolao","https://3.bp.blogspot.com/-oUY5MNroVpk/U83Q3FGQ-OI/AAAAAAAADbE/x4YkV3bssU8/s1600/2014-07-22+01.52.27-1.png"));
//        arr.add(new cauhoi("cau 3","thientai","https://1.bp.blogspot.com/-mEiuv7pcJRY/U8258B5I1mI/AAAAAAAADXE/k-bid3Zliwg/s1600/2014-07-22+01.39.30-1.png"));
//        arr.add(new cauhoi("cau 4","hoga","https://1.bp.blogspot.com/-gyz54ig8HzY/U825SHd7yyI/AAAAAAAADWU/eScqetwzDVE/s1600/2014-07-22+01.35.15-1.png"));
//        arr.add(new cauhoi("cau 5","baocao","https://3.bp.blogspot.com/-pzQILmYu4Jw/U8ePEjoEW2I/AAAAAAAACq8/QN8KosNpR70/s1600/2014-07-17+00.43.58-1.png"));

    }
    public cauhoi laycauhoi(){
        causo++;
        if(causo==arr.size())
        {
            causo=arr.size()-1;
        }
        return arr.get(causo);
    }


    public cauhoi laycau(){
        Random rd=new Random();
            int so=rd.nextInt((arr.size()-1+1)+1);
            if(so==arr.size())
            {
                so=arr.size()-1;
            }
        return arr.get(so);
    }



    public void laytt(){ nguoichoi.gettt(c);
    }
    public void luutt(){
        nguoichoi.savett(c);
    }

}
