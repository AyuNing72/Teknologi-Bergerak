package com.example.godrink;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterPromoBulanan extends ArrayAdapter {
    String[] nm_blnan;
    int[] gmbr_blnan;

    Activity activity;

    public AdapterPromoBulanan(MainActivity5 activity, String[] nama_Bulanan, int[] gambar_Bulanan) {

        super(activity,R.layout.list_bulanan,nama_Bulanan);
        this.nm_blnan = nama_Bulanan;
        this.gmbr_blnan =gambar_Bulanan;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view1 = inflater.inflate(R.layout.list_bulanan, null);

        ImageView Gmbarblnn;
        TextView ketrngnblnn;

        Gmbarblnn = view1.findViewById(R.id.Gmbar_bulanann);
        ketrngnblnn = view1.findViewById(R.id.nama_bulanann);

        Gmbarblnn.setImageResource(gmbr_blnan[position]);
        ketrngnblnn.setText(nm_blnan[position]);
        return view1;
    }
}
