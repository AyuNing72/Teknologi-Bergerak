package com.example.latihantekber1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView ft;
    TextView nama3 , Nim4, Alamat4;
    String name="nama" , mNim="Nim", mAlamat="Alamat" , mGambar="GG";
    String TempatNama ,TmptNim1 , TmptAlamt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ft=findViewById(R.id.Gmbarin);
        nama3=findViewById(R.id.NamaKu);
        Nim4=findViewById(R.id.Nim1);
        Alamat4=findViewById(R.id.Alamat2);

        Bundle bundle=getIntent().getExtras();
        TempatNama=bundle.getString(name);
        TmptNim1=bundle.getString(mNim);
        TmptAlamt=bundle.getString(mAlamat);

        int tampilgambar=bundle.getInt(mGambar);

        nama3.setText("Nama   : "+TempatNama);
        Nim4.setText("NIM : "+TmptNim1);
        Alamat4.setText("Alamat : "+TmptAlamt);
        ft.setImageResource(tampilgambar);
    }
}