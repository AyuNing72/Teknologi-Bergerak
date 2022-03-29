package com.example.hellotoast;

import androidx.annotation.ColorRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Hello_Toast extends AppCompatActivity {
    TextView tos;
    int Angkaaa=0;
    Button Satu, Dua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tos=findViewById(R.id.Angka);
        Satu=findViewById(R.id.tombol_Count);
        Dua=findViewById(R.id.tombol_toast);

    }

    public void Delay(View view) {
        //Toast.makeText(,"",Toast.LENGTH_SHORT).show();
        Toast toastku=Toast.makeText(Hello_Toast.this,"Saya adalah TOAST",Toast.LENGTH_SHORT);
        //Toast toastku=Toast.makeText(getApplicationContext(),"Saya adalah TOAST",1);
        toastku.show();
    }

    @SuppressLint("SetTextI18n")
    public void Hitung(View view) {
        ++Angkaaa;
        //Angkaaa=Angkaaa+1;

        if (Angkaaa %2 == 0) {
            //tos.setTextColor(Color.BLUE);
            tos.setBackgroundColor(Color.GREEN);
        }
        else {
            //tos.setTextColor(Color.BLACK);
            tos.setBackgroundColor(Color.WHITE);
        }
        tos.setText(Integer.toString(Angkaaa));

    }
}