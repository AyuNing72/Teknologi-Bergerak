package com.example.godrink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity6 extends AppCompatActivity {

    ImageView GambarGift3t;
    ListView listVieww;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        // TAMBAHKAN INI
        GambarGift3t = findViewById(R.id.imageTerlariss);

        Glide.with(MainActivity6.this)
                // LOAD URL DARI LOKAL DRAWABLE
                .load(R.drawable.terlaris)
                .into(GambarGift3t);

        String nama_trlariss[]={"chattime \n Pearl Milk Tea \n Rp.17.000 . Minuman, Cepat Saji" ,
                "Boba \n coffee Milk \n Rp. 22.000. Minuman, Cepat Saji, Jajanan",
                "Splash \n Tea Milk \n Rp. 15.000. Cepat Saji, Minuman, Aneka topping" ,
                "Gulu-Gulu \n Soda Milk \n Rp. 20.000. Aneka Topping, Jajanan, Minuman"};

        int gambar_trlaris[]={R.drawable.chattime,R.drawable.xie_boba,
                R.drawable.sedot,R.drawable.gulugulu};

        listVieww=findViewById(R.id.ListTerlariss);
        AdapterTerlaris adapterTerlaris=new AdapterTerlaris(this,nama_trlariss,gambar_trlaris);
        listVieww.setAdapter(adapterTerlaris);
        listVieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity6.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    public void back(View view) {
        Intent intent=new Intent(MainActivity6.this,MainActivity.class);
        startActivity(intent);
    }
}