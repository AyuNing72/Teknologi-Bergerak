package com.example.responsi_71221;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.DataTruncation;

public class MainActivityUpdate extends AppCompatActivity {

    DatabasesHelper Dbh;
    EditText Tkjr, TMkul, Tsks, Tnangka, THrf, Tpre;
    Button Btnshow, BtnUp, BtnDelete, BtnEnter;

    String JKd="Kodejr";
    String Jmkul="Matkul";
    String Jsks="SKSny";
    String Jnangka="N_angkaany";
    String JHrf="N_hrufnya";
    String JPred="VPred";

    String TmpngKd, TmpngMkul, TmpngSks, TmpngNangka, TmpangHrf, TmpngPred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);

        Tkjr=findViewById(R.id.KodeMHSUp);
        TMkul=findViewById(R.id.MkulMHSUp);
        Tsks=findViewById(R.id.SksMHSUp);
        Tnangka=findViewById(R.id.NangkaMHSUp);
        THrf=findViewById(R.id.NHrfMHSUp);
        Tpre=findViewById(R.id.PredMHSUp);

        Btnshow=findViewById(R.id.Tombol_Show2);
        BtnUp=findViewById(R.id.Tombol_Update);
        BtnDelete=findViewById(R.id.Tombol_Hapus2);
        BtnEnter=findViewById(R.id.Tombol_Hasil2);

        Dbh=new DatabasesHelper(this);

        Bundle Up=getIntent().getExtras();
        TmpngKd=Up.getString(JKd);
        TmpngMkul=Up.getString(Jmkul);
        TmpngSks=Up.getString(Jsks);
        TmpngNangka=Up.getString(Jnangka);
        TmpangHrf=Up.getString(JHrf);
        TmpngPred=Up.getString(JPred);

        Tkjr.setText(TmpngKd);
        TMkul.setText(TmpngMkul);
        Tsks.setText(TmpngSks);
        Tnangka.setText(TmpngNangka);
        THrf.setText(TmpangHrf);
        Tpre.setText(TmpngPred);


        BtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dbh.updte_dta(Tkjr.getText().toString(),TMkul.getText().toString(),
                        Tsks.getText().toString(), Tnangka.getText().toString(), THrf.getText().toString());
                Toast.makeText(getApplicationContext(),"Update Sukses",Toast.LENGTH_SHORT).show();
            }
        });

        Btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivityUpdate.this,MainActivityview.class);
                startActivity(intent);
            }
        });

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dbh.hapus_data(Tkjr.getText().toString());
                Toast.makeText(getApplicationContext(),"Data Terhapus",Toast.LENGTH_SHORT).show();
            }
        });

        BtnEnter.setOnClickListener((new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                int Q_angka=Integer.parseInt(String.valueOf(Tnangka.getText()));
                if(Q_angka<60){
                    THrf.setText("D");
                    Tpre.setText("SANGAT KURANG");
                    //xpredikat.setTooltipText("BELAJAR LEBIH GIAT YA !");
                }
                else if(Q_angka<70){
                    THrf.setText("C");
                    Tpre.setText("MEMUASKAN");
                    //xpredikat.setError("PERBAIKI LAGI YA !");
                }
                else if(Q_angka<80){
                    THrf.setText("B");
                    Tpre.setText("TERPUJI");
                    //xpredikat.setError("TINGKATKAN LAGI YA !");
                }
                else if(Q_angka>=80){
                    THrf.setText("A");
                    Tpre.setText("ISTIMEWA");
                    //xpredikat.setTooltipText("PERTAHANKAN YA !");
                }
            }
        }));
    }
}