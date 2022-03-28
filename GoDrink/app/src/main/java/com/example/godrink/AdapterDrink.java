package com.example.godrink;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterDrink extends ArrayAdapter {
    String nm_promo[];
    int gmbr_promo[];

    Activity activity;

    public AdapterDrink(MainActivity3 activity, String[] nama_promo, int[] gambar_Promo) {

        super(activity,R.layout.list_promo1,nama_promo);
        this.nm_promo = nama_promo;
        this.gmbr_promo = gambar_Promo;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View vp = inflater.inflate(R.layout.list_promo1, null);

        ImageView GmbarPro;
        TextView KetPro;

        GmbarPro = vp.findViewById(R.id.Gmbar_promo);
        KetPro = vp.findViewById(R.id.Ket_Promo);

        GmbarPro.setImageResource(gmbr_promo[position]);
        KetPro.setText(nm_promo[position]);
        return vp;
    }
}
