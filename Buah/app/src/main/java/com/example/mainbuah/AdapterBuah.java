package com.example.mainbuah;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterBuah extends ArrayAdapter {
    String nm_buah[];
    int gmbr_buah[];
    String Keterangan[];

    Activity activity;

    public AdapterBuah(MainActivity activity,String[] nama_buah, int[] gambar_buah, String[] keterangan_Buah) {
        super(activity,R.layout.list_item,nama_buah);
        this.nm_buah = nama_buah;
        this.gmbr_buah = gambar_buah;
        this.Keterangan = keterangan_Buah;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_item,null);

        ImageView Gmbar;
        TextView Ket;

        Gmbar=v.findViewById(R.id.buah_gmbr);
        Ket=v.findViewById(R.id.Ket_Buah);

        Gmbar.setImageResource(gmbr_buah[position]);
        Ket.setText(nm_buah[position]);
        return v;
    }
}
