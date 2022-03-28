package com.example.godrink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void checkout(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }
    public void chattime(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }

    public void xieboba(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }

    public void barumingguini(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity3.class);
        startActivity(intent);
    }


    public void terdekatmap(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity4.class);
        startActivity(intent);

    }

    public void promobulanan(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity5.class);
        startActivity(intent);
    }

    public void Terlaris(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity6.class);
        startActivity(intent);
    }
}