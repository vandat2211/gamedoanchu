package com.example.gamedoanchu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gamedoanchu.R;

import java.util.ArrayList;
import java.util.List;

public class DapanAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> arrayList;
    public DapanAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.arrayList=new ArrayList<>(objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      if(convertView==null){
          LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView=inflater.inflate(R.layout.item_cautraloi,null);
      }
        TextView tvctl=convertView.findViewById(R.id.tvctl);
      tvctl.setText(this.arrayList.get(position));
      return convertView;
    }
}
