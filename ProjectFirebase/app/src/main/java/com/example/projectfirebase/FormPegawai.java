package com.example.projectfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.PeriodicAdvertisingParameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormPegawai extends AppCompatActivity {

    EditText xnopeg, xnmapeg, xjabatan;
    Button tblSimpan;
    DatabaseReference dbref;
    Pegawai pgw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pegawai);


        xnopeg=findViewById(R.id.no_pegawai);
        xnmapeg=findViewById(R.id.nama_pegawai);
        xjabatan=findViewById(R.id.jabatan_pegawai);
        tblSimpan=findViewById(R.id.tombolsimpan);

        pgw= new Pegawai();
        dbref= FirebaseDatabase.getInstance().getReference().child("AbsenPegawai");

        tblSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pgw.setNomor_peg(xnopeg.getText().toString().trim());
                pgw.setNama_peg(xnmapeg.getText().toString().trim());
                pgw.setJabatan(xjabatan.getText().toString().trim());

                dbref.push().setValue(pgw);
            }
        });
    }
}