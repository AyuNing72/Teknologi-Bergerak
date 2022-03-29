package com.example.latihantekber1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity1 extends AppCompatActivity {
    EditText Namaa , Niim , Aalamat;
    Button button;
    ImageView fot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        fot=findViewById(R.id.gambarKu);
        Namaa=findViewById(R.id.Nama1);
        Niim=findViewById(R.id.NimKu);
        Aalamat=findViewById(R.id.Alamat1);

        button=findViewById(R.id.tmbolbutton);
    }

    public void BukaData(View view) {
        String isinama=Namaa.getText().toString();
        String isinim=Niim.getText().toString();
        String isialamat=Aalamat.getText().toString();
        Intent intent=new Intent(MainActivity1.this,MainActivity2.class);
        intent.putExtra("nama",isinama);
        intent.putExtra("Nim",isinim);
        intent.putExtra("Alamat",isialamat);
        intent.putExtra("GG",R.drawable.foto1);

        startActivity(intent);
    }
}