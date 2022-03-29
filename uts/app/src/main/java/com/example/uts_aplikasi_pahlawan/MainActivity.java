package com.example.uts_aplikasi_pahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void KirimData1(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivityuts2.class);
        startActivity(intent);
    }
}