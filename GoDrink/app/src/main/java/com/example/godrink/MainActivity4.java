package com.example.godrink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity4 extends AppCompatActivity {

    ImageView GambarGift2;
    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // TAMBAHKAN INI
        GambarGift2 = findViewById(R.id.imageTerdekat);

        Glide.with(MainActivity4.this)
                // LOAD URL DARI LOKAL DRAWABLE
                .load(R.drawable.terdekatdesign)
                .into(GambarGift2);

        String nama_terdkt[]={"chattime \n Pearl Milk Tea \n Rp.17.000 . Minuman, Cepat Saji" ,
                "Boba \n coffee Milk \n Rp. 22.000. Minuman, Cepat Saji, Jajanan",
                "Splash \n Tea Milk \n Rp. 15.000. Cepat Saji, Minuman, Aneka topping" ,
                "Gulu-Gulu \n Soda Milk \n Rp. 20.000. Aneka Topping, Jajanan, Minuman"};

        int gambar_terdkt[]={R.drawable.chattime,R.drawable.xie_boba,
                R.drawable.sedot,R.drawable.gulugulu};

        listView2=findViewById(R.id.ListTerdekat1);
        AdapterTerdekat adpterTerdekat=new AdapterTerdekat(this,nama_terdkt,gambar_terdkt);
        listView2.setAdapter(adpterTerdekat);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity4.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    public void back(View view) {
        Intent intent=new Intent(MainActivity4.this,MainActivity.class);
        startActivity(intent);
    }
}