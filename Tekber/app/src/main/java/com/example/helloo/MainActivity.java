package com.example.helloo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView toss;
    int Aangka;
    Button saatu, duua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toss=findViewById(R.id.Angkaa1);
        saatu=findViewById(R.id.Toast1);
        duua=findViewById(R.id.Hitung1);
    }

    public void Delay1(View view) {
        //Toast.makeText(,"",Toast.LENGTH_SHORT).show();
        Toast toastku=Toast.makeText(MainActivity.this,"Saya adalah TOAST",Toast.LENGTH_LONG);
        //Toast toastku=Toast.makeText(getApplicationContext(),"Saya adalah TOAST",1);
        toastku.show();
    }

    @SuppressLint("SetTextI18n")
    public void Hituung(View view) {
        ++Aangka;

        if (Aangka %2 == 0) {
            toss.setBackgroundColor(Color.GREEN);
        }
        else {
            toss.setBackgroundColor(Color.WHITE);
        }
        toss.setText(Integer.toString(Aangka));

    }
}