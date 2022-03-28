package com.example.godrink;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterTerlaris extends ArrayAdapter {
    String[] nm_trlaris;
    int[] gmbr_trlariss;

    Activity activity;

    public AdapterTerlaris(MainActivity6 activity, String[] nama_trlariss, int[] gambar_trlaris) {

        super(activity,R.layout.list_trlariss,nama_trlariss);
        this.nm_trlaris = nama_trlariss;
        this.gmbr_trlariss =gambar_trlaris;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view12 = inflater.inflate(R.layout.list_trlariss, null);

        ImageView Gmbartrlariss;
        TextView ketrngntrlariss;

        Gmbartrlariss = view12.findViewById(R.id.Gmbar_trlariss);
        ketrngntrlariss = view12.findViewById(R.id.nama_trlariss);

        Gmbartrlariss.setImageResource(gmbr_trlariss[position]);
        ketrngntrlariss.setText(nm_trlaris[position]);
        return view12;
    }
}
