package com.example.mainbuah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBuah extends AppCompatActivity {
    ImageView gmbrrmasuk;
    TextView nmabbuahmasuk, ketbuahmasuk;

    String kunci_nm="nnmaBuah";
    String  ket_kunci="pnjlsnbuah";
    int gbrbuah;

    String namebuahe;
    String ketbuahe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);

        gmbrrmasuk=findViewById(R.id.gmbardetail);
        nmabbuahmasuk=findViewById(R.id.titlebuah);
        ketbuahmasuk=findViewById(R.id.kket_buah);

        Bundle bundle=getIntent().getExtras();

        gbrbuah=bundle.getInt(String.valueOf("gbrbuah"));
        gmbrrmasuk.setImageResource(gbrbuah);

        namebuahe=bundle.getString("nnmaBuah");
        ketbuahe=bundle.getString("pnjlsnbuah");

        nmabbuahmasuk.setText(namebuahe);
        ketbuahmasuk.setText(ketbuahe);


    }
}