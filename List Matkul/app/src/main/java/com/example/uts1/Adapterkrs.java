package com.example.uts1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapterkrs extends ArrayAdapter {
    String[] nokrs;
    String[] kdkrs;
    String[] nmkrs;
    String[] skskrs;
    String[] nilAkrs;
    String[] nilHkrs;

    Activity activity1;

    public Adapterkrs(ActivityKrs activity1, String[] no_krs, String[] kode_krs, String[] nama_krs,
                      String[] sks_krs, String[] nilaiA_krs, String[] nilaiH_krs) {
        super(activity1, R.layout.list_krs, no_krs);
        this.nokrs = no_krs;
        this.kdkrs = kode_krs;
        this.nmkrs = nama_krs;
        this.skskrs = sks_krs;
        this.nilAkrs = nilaiA_krs;
        this.nilHkrs = nilaiH_krs;
        this.activity1 = activity1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=activity1.getLayoutInflater();
        View krs1=inflater.inflate(R.layout.list_krs,null);

        TextView nomor;
        TextView kde;
        TextView nma;
        TextView skss;
        TextView nilA;
        TextView nilH;

        nomor=krs1.findViewById(R.id.No1);
        kde=krs1.findViewById(R.id.kodeMk1);
        nma=krs1.findViewById(R.id.nmmtkul1);
        skss=krs1.findViewById(R.id.sks1);
        nilA=krs1.findViewById(R.id.nilaiA1);
        nilH=krs1.findViewById(R.id.nilaiH1);

        nomor.setText(nokrs[position]);
        kde.setText(kdkrs[position]);
        nma.setText(nmkrs[position]);
        skss.setText(skskrs[position]);
        nilA.setText(nilAkrs[position]);
        nilH.setText(nilHkrs[position]);
        return krs1;
    }
}
