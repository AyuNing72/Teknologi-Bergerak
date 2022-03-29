package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    ListView listView1;
    Button tblinput;
    ArrayList<String> listitem1;
    ArrayAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1=findViewById(R.id.List_data);
        tblinput=findViewById(R.id.Inputdata);
        dbh=new DatabaseHelper(this);
        listitem1=new ArrayList<>();

        //Input Data ke dalam tabel Mahasiswa

        /*String nim="A12.2019.06281";
        String nama="Dewi Putri Ayuningsihd";

        dbh.tambah_data(nim,nama);*/

        //Tampilkan data Mahasiswa
        final Cursor[] cursor1 = {dbh.baca_dta()};

        listitem1.clear();
        while (cursor1[0].moveToNext())
        {
            listitem1.add(cursor1[0].getString(0)+" "+ cursor1[0].getString(1));
        }
        adapter1=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,listitem1);
        listView1.setAdapter(adapter1);

        tblinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, input_mhs.class);
                startActivity(intent);
            }
        });

        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivity.this,Edit_Mhs.class);

                final Cursor[] cursor1 = {dbh.baca_dta()};
                cursor1[0].moveToPosition(position);
                String Tnim=cursor1[0].getString(0);
                String Tnama=cursor1[0].getString(1);

                 /*Toast.makeText(getApplicationContext()," " +Tnim, Toast.LENGTH_SHORT).show();
               String animm=(listitem1.get(position).substring(0,14));
                int pnjg=listitem1.get(position).length();
                String anamaa=(listitem1.get(position).substring(14 ,pnjg)); */

                intent.putExtra("Nimnya",Tnim);
                intent.putExtra("Namanya",Tnama);

                startActivity(intent);
                return false;
            }
        });
    }
}