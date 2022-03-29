package com.example.uts_aplikasi_pahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPhlwn extends AppCompatActivity {
    ImageView gmbrrmasuk1;
    TextView nmaphlwnmasuk, ketphlwnmasuk;

    String kunci_nm1="nmaplwn";
    String  ket_kunci1="pnjlsnplwn";
    int gmbrplwn;

    String namephlwane;
    String ketphlwane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_phlwn);

        gmbrrmasuk1=findViewById(R.id.gmbardetail);
        nmaphlwnmasuk=findViewById(R.id.titlenama);
        ketphlwnmasuk=findViewById(R.id.kkeplhwn);

        Bundle bundle=getIntent().getExtras();

        gmbrplwn=bundle.getInt(String.valueOf("gmbrplwn"));
        gmbrrmasuk1.setImageResource(gmbrplwn);

        namephlwane=bundle.getString("nmaplwn");
        ketphlwane=bundle.getString("pnjlsnplwn");

        nmaphlwnmasuk.setText(namephlwane);
        ketphlwnmasuk.setText(ketphlwane);
    }
}