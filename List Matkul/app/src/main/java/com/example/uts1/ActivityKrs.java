package com.example.uts1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ActivityKrs extends AppCompatActivity {
    ListView listkrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krs);

        String no_krs[]={"1", "2", "3", "4", "5", "6", "7"};

        String kode_krs[]={"A12.66401", "A12.66403", "A12.66404",
                "A12.66405", "A12.66601", "A12.66602", "A12.66605"};

        String nama_krs[]={"ANSI 2" , "PBO",
                "PWEB" , "PROBAB",
                "PSDP" , "IPS", "MRP"};

        String sks_krs[]={"4", "4", "4", "3"
                        ,"3" , "2", "3"};

        String nilaiA_krs[]={"88.25", "82", "75", "81.2",
                            "70.5", "85", "86.8"};

        String nilaiH_krs[]={"A", "AB", "B", "AB", "B"
                            ,"A", "A"};

        listkrs=findViewById(R.id.Listdatakrs);
        Adapterkrs adapterkrs1=new Adapterkrs(this, no_krs, kode_krs, nama_krs,
                sks_krs, nilaiA_krs, nilaiH_krs);
        listkrs.setAdapter(adapterkrs1);
    }
}