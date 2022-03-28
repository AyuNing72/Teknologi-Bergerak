package com.example.pfirebase06284;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menuju_ke(View view) {
        Intent intent=new Intent(MainActivity1.this,FormPegawai.class);
        startActivity(intent);
    }
}