package com.example.uts_aplikasi_pahlawan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class AdapterPahlawan extends ArrayAdapter {
    String nm_plwn[];
    int gmbr_plwn[];
    String Keterangan[];

    Activity activityplwn;

    public AdapterPahlawan( MainActivityuts2 activityplwn, String[] nama_palwn, int[] gambar_phlwn,
                            String[] Keterangan_phlwn) {
        super(activityplwn, R.layout.list_phlwn,nama_palwn);
        this.nm_plwn = nama_palwn;
        this.gmbr_plwn = gambar_phlwn;
        Keterangan = Keterangan_phlwn;
        this.activityplwn = activityplwn;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=activityplwn.getLayoutInflater();
        View plwn=inflater.inflate(R.layout.list_phlwn,null);

        ImageView Gmbarr;
        TextView Kett;

        Gmbarr=plwn.findViewById(R.id.gmbr_Plwn);
        Kett=plwn.findViewById(R.id.nmaa_Plwn);

        Gmbarr.setImageResource(gmbr_plwn[position]);
        Kett.setText(nm_plwn[position]);
        return plwn;
    }
}
