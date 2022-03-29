package com.example.uas_06284;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TampilDataGuru extends AppCompatActivity implements PegawaiAdaptor.datalistener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    Button tblinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data_guru);
        recyclerView = findViewById(R.id.masterdataguru);
        tblinput=findViewById(R.id.tomboladd);

        MyRecyclerView();
        GetData();

        tblinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TampilDataGuru.this, FormPegawai.class);
                startActivity(intent);
            }
        });
    }


    //Deklarasi Variable Database Reference dan ArrayList dengan Parameter Class Model kita.
    private DatabaseReference reference;
    private ArrayList<Pegawai> dataKaryawans;

    private void GetData() {
        //Mendapatkan Referensi Database
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("AbsenPegawai").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataKaryawans = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Pegawai karyawan = snapshot.getValue(Pegawai.class);
                    karyawan.setKey(snapshot.getKey());
                    dataKaryawans.add(karyawan);
                }

                //Inisialisasi Adapter dan data Mahasiswa dalam bentuk Array
                adapter = new PegawaiAdaptor(dataKaryawans, TampilDataGuru.this);

                //Memasang Adapter pada RecyclerView
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Data Gagal Dimuat",Toast.LENGTH_LONG).show();
                //Log.e("MyListActivity", databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });
    }

    //Methode yang berisi kumpulan baris kode untuk mengatur RecyclerView
    private void MyRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public void onDeleteData(Pegawai data, int position) {
        if (reference != null) {
            reference.child("AbsenPegawai")
                    .child(data.getKey())
                    .removeValue()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(TampilDataGuru.this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    }

    public void tblhome(View view) {
        Intent intent = new Intent(TampilDataGuru.this, MainActivity.class);
        startActivity(intent);
    }
}