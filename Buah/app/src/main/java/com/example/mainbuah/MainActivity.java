package com.example.mainbuah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nama_buah[]={"Durian" , "Elai",
                            "Matoa" , "Manggis",
                            "Apel" , "Anggur",
                            "Pisang" , "Mangga"};

        int gambar_buah[]={R.drawable.durian,R.drawable.elai,
                           R.drawable.matoa,R.drawable.manggis,
                           R.drawable.apel, R.drawable.anggur,
                            R.drawable.pisang,R.drawable.mangga };

        String Keterangan_Buah[]={"Buah yang disebut sebagai raja nya buah",
                            "Buah yang hanya terdapat di daerah kalimantan",
                            "Buah yang mirip dengan Kelengkeng",
                            "Buah yang kulitnya dapat dibuat minuman sehat",
                            "Buah yang berwarna Merah dan mudah untuk di jumpai",
                            "Buah yang memiliki 3 jenis warna",
                            "Buah yang mengandung Vit B",
                            "Buah yang mengandung Vit C"};

        listView=findViewById(R.id.Listdatabuah);
        AdapterBuah adapterBuah=new AdapterBuah(this,nama_buah,gambar_buah,Keterangan_Buah);
        listView.setAdapter(adapterBuah);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String abuah=nama_buah[position].toString();
               int ggbrbuah=gambar_buah[position];
               String kket=Keterangan_Buah[position].toString();

               //Toast.makeText(MainActivity.this,""+ggbrbuah, Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(MainActivity.this,DetailBuah.class);
               intent.putExtra("nnmaBuah",abuah);
               intent.putExtra("gbrbuah",ggbrbuah);
               intent.putExtra("pnjlsnbuah",kket);
               startActivity(intent);
            }
        });

    }
}