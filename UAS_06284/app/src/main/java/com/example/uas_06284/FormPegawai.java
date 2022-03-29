package com.example.uas_06284;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormPegawai extends AppCompatActivity {
    EditText xnopeg, xnmapeg, xjabatan, xharga, xsatuan;
    Button tblSimpan;
    DatabaseReference dbref;
    Pegawai pgw;

    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pegawai);

        //DropdownMenu
        spinner1 = (Spinner) findViewById(R.id.satuan_barang);

        xnopeg=findViewById(R.id.no_pegawai);
        xnmapeg=findViewById(R.id.nama_pegawai);
        xjabatan=findViewById(R.id.jabatan_pegawai);
        xharga=findViewById(R.id.Harga_Brg);
        //xsatuan=findViewById(R.id.satuan_barang);
        tblSimpan=findViewById(R.id.tombolsimpan);

        pgw= new Pegawai();
        dbref= FirebaseDatabase.getInstance().getReference().child("AbsenPegawai");

        tblSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pgw.setKd_barang(xnopeg.getText().toString().trim());
                pgw.setNama_barang(xnmapeg.getText().toString().trim());
                pgw.setJml_barang(xjabatan.getText().toString().trim());
                pgw.setHarga(xharga.getText().toString().trim());
                pgw.setSatuan_brg(spinner1.getSelectedItem().toString().trim());

                dbref.push().setValue(pgw);

                Toast.makeText(FormPegawai.this, "Data Berhasil ditambah",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void tmblView(View view) {
        Intent intent= new Intent(FormPegawai.this, TampilDataGuru.class);
        startActivity(intent);
    }
}