package com.example.godrink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    ListView listView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        String nama_Bulanan[]={ "Splash \n Tea Milk \n Rp. 15.000. Cepat Saji, Minuman, Aneka topping",
                "Gulu-Gulu \n Soda Milk \n Rp. 20.000. Aneka Topping, Jajanan, Minuman",
                "chattime \n Pearl Milk Tea \n Rp.17.000 . Minuman, Cepat Saji",
                "Boba \n coffee Milk \n Rp. 22.000. Minuman, Cepat Saji, Jajanan" };

        int gambar_Bulanan[]={R.drawable.sedot,R.drawable.gulugulu,
                R.drawable.chattime,R.drawable.xie_boba};

        listView3=findViewById(R.id.Listpromobulanan);
        AdapterPromoBulanan adapterPromoBulanan=new AdapterPromoBulanan(this,nama_Bulanan,gambar_Bulanan);
        listView3.setAdapter(adapterPromoBulanan);
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity5.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    public void back(View view) {
        Intent intent=new Intent(MainActivity5.this,MainActivity.class);
        startActivity(intent);
    }
}