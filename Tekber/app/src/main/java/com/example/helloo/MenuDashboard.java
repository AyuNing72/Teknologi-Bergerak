package com.example.helloo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_dashboard);
    }

    public void masuk(View view) {
        Intent intent=new Intent(MenuDashboard.this,MainActivity.class);
        startActivity(intent);
    }

    public void prof(View view) {
        Intent intent=new Intent(MenuDashboard.this,Profile.class);
        startActivity(intent);
    }
}