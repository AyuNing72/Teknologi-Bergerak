package com.example.responsi_71221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityview extends AppCompatActivity {

    DatabasesHelper Dbh;
    ListView listView2;
    Button Tblinput;
    ArrayList<String> listitem2;
    ArrayAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityview);

        listView2=findViewById(R.id.ListKHS);
        Tblinput=findViewById(R.id.Tombol_input);
        Dbh=new DatabasesHelper(this);
        listitem2=new ArrayList<>();

        //Tampilkan data Mahasiswa
        final Cursor[] cursor1 = {Dbh.baca_dta()};

        listitem2.clear();
        while (cursor1[0].moveToNext())
        {
            listitem2.add(cursor1[0].getString(0)+" "+ cursor1[0].getString(1)+" "+ cursor1[0].getString(2)+" "+
                    cursor1[0].getString(3)+" "+ cursor1[0].getString(4));
        }
        adapter2=new ArrayAdapter(MainActivityview.this,R.layout.support_simple_spinner_dropdown_item,listitem2);
        listView2.setAdapter(adapter2);

        Tblinput.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent=new Intent(MainActivityview.this, MainActivity.class);
                startActivity(intent);
            }
        });

        listView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivityview.this,MainActivityUpdate.class);

                final Cursor[] cursor1 = {Dbh.baca_dta()};
                cursor1[0].moveToPosition(position);
                String Tkjr=cursor1[0].getString(0);
                String TMkul=cursor1[0].getString(1);
                String Tsks=cursor1[0].getString(2);
                String Tnangka=cursor1[0].getString(3);
                String THrf=cursor1[0].getString(4);

                /*Toast.makeText(getApplicationContext()," " +Tnim, Toast.LENGTH_SHORT).show();
               String animm=(listitem1.get(position).substring(0,14));
                int pnjg=listitem1.get(position).length();
                String anamaa=(listitem1.get(position).substring(14 ,pnjg)); */

                intent.putExtra("Kodejr",Tkjr);
                intent.putExtra("Matkul",TMkul);
                intent.putExtra("SKSny",Tsks);
                intent.putExtra("N_angkaany",Tnangka);
                intent.putExtra("N_hrufnya",THrf);



                startActivity(intent);
                return false;
            }
        });
    }
}