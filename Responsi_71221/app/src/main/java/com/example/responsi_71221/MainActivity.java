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

public class MainActivity extends AppCompatActivity {
    Button Tblsimpan, TblView, TblEnter;
    EditText xkjr, xMkul, xsks, xnangka, xHrf, xpre;
    DatabasesHelper Dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xkjr=findViewById(R.id.KodeMHS);
        xMkul=findViewById(R.id.MkulMHS);
        xsks=findViewById(R.id.SksMHS);
        xnangka=findViewById(R.id.NangkaMHS);
        xHrf=findViewById(R.id.NHrfMHS);
        xpre=findViewById(R.id.PredMHS);

        Dbh=new DatabasesHelper(this);
        Tblsimpan=findViewById(R.id.Tombol_save2);
        TblView=findViewById(R.id.Tombol_View2);
        TblEnter=findViewById(R.id.Tombol_Hasil);

        Tblsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xkjr.getText().length()<6 || xkjr.getText().length()>6 )
                {
                    xkjr.setError("Wajib 6 karakter");
                    Toast.makeText(getApplicationContext(),"Maaf masukan 14 karakter",Toast.LENGTH_SHORT).show();
                    xkjr.requestFocus();
                } else {
                    Dbh.Tambah_data(xkjr.getText().toString(), xMkul.getText().toString(),
                            xsks.getText().toString(), xnangka.getText().toString(),
                            xHrf.getText().toString());
                }
            }
        });

        TblView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivityview.class);
                startActivity(intent);
            }
        });


        TblEnter.setOnClickListener((new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                int Q_angka=Integer.parseInt(String.valueOf(xnangka.getText()));
                if(Q_angka<60){
                    xHrf.setText("D");
                    xpre.setText("SANGAT KURANG");
                    //xpre.setTooltipText("BELAJAR LEBIH GIAT YA !");
                }
                else if(Q_angka<70){
                    xHrf.setText("C");
                    xpre.setText("MEMUASKAN");
                    //xpre.setError("PERBAIKI LAGI YA !");
                }
                else if(Q_angka<80){
                    xHrf.setText("B");
                    xpre.setText("TERPUJI");
                    //xpre.setError("TINGKATKAN LAGI YA !");
                }
                else if(Q_angka>=80){
                    xHrf.setText("A");
                    xpre.setText("ISTIMEWA");
                    //xpre.setTooltipText("PERTAHANKAN YA !");
                }
            }
        }));
    }
}