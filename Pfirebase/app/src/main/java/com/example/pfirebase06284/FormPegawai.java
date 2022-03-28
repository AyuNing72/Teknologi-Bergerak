package com.example.pfirebase06284;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormPegawai extends AppCompatActivity {
    EditText xnopeg, xnmapeg, xjabatan;
    Button tblSimpan,tblview;
    DatabaseReference dbref;
    Pegawai pegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pegawai);

        xnopeg=findViewById(R.id.nomor_pgw);
        xnmapeg=findViewById(R.id.nama_pgw);
        xjabatan=findViewById(R.id.jabatan_pgw);
        tblSimpan=findViewById(R.id.tombolsimpan);
        tblview=findViewById(R.id.tombolview);

        pegawai=new Pegawai();

        dbref= FirebaseDatabase.getInstance().getReference().child("AbsenPegawai");
    }
    public void tblSimpan(View view) {
        pegawai.setNomor_peg(xnopeg.getText().toString().trim());
        pegawai.setNama_peg(xnmapeg.getText().toString().trim());
        pegawai.setJabatan(xjabatan.getText().toString().trim());

        dbref.push().setValue(pegawai);
    }
    public void tblview(View view){
        Intent intent=new Intent(FormPegawai.this,TampilDataGuru.class);
        startActivity(intent);
    }

}