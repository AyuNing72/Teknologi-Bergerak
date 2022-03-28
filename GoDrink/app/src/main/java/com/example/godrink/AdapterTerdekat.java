package com.example.godrink;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterTerdekat extends ArrayAdapter {
    String[] nm_trdkt;
    int[] gmbr_trdkt;

    Activity activity;

    public AdapterTerdekat(MainActivity4 activity, String[] nama_terdkt, int[] gambar_terdkt) {

        super(activity,R.layout.list_terdekat,nama_terdkt);
        this.nm_trdkt = nama_terdkt;
        this.gmbr_trdkt =gambar_terdkt;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_terdekat, null);

        ImageView Gmbarterdekt;
        TextView ketrngntrdkt;

        Gmbarterdekt = view.findViewById(R.id.Gmbar_trdkt);
        ketrngntrdkt = view.findViewById(R.id.nama_trdktt);

        Gmbarterdekt.setImageResource(gmbr_trdkt[position]);
        ketrngntrdkt.setText(nm_trdkt[position]);
        return view;
    }
}
