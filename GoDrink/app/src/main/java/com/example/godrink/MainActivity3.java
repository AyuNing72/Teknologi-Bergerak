package com.example.godrink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class MainActivity3 extends AppCompatActivity {
    ImageView GambarGift;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // TAMBAHKAN INI
        GambarGift = findViewById(R.id.imageViewku);

        Glide.with(MainActivity3.this)
                // LOAD URL DARI LOKAL DRAWABLE
                .load(R.drawable.ataas)
                .into(GambarGift);

        String nama_promo[]={"chattime \n Pearl Milk Tea \n Rp.17.000" ,
                             "Boba \n coffee Milk \n Rp. 22.000",
                             "Splash \n Tea Milk \n Rp. 15.000" ,
                             "Gulu-Gulu \n Soda Milk \n Rp. 20.000"};

        int gambar_Promo[]={R.drawable.chattime,R.drawable.xie_boba,
                R.drawable.sedot,R.drawable.gulugulu};


        listView1=findViewById(R.id.ListPromo);
        AdapterDrink adapterDrink=new AdapterDrink(this,nama_promo,gambar_Promo);
        listView1.setAdapter(adapterDrink);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    public void back(View view) {
        Intent intent=new Intent(MainActivity3.this,MainActivity.class);
        startActivity(intent);
    }
}