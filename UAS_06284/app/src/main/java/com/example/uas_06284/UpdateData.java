package com.example.uas_06284;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.BreakIterator;

public class UpdateData extends AppCompatActivity {

    //Deklarasi Variable
    private EditText nipBaru;
    private EditText namaBaru;
    private EditText jabbaru;
    private EditText harbaru1;
    private EditText satbaru;
    private Button btnupdate,btndelete,btnview;
    private DatabaseReference dtabse;
    private String cekNIP, cekNama,cekJabat, cekharg, ceksat;
    Pegawai pgawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        nipBaru = findViewById(R.id.new_nip);
        namaBaru = findViewById(R.id.new_nama);
        jabbaru = findViewById(R.id.new_jab);
        harbaru1 =findViewById(R.id.new_Harga);
        satbaru = findViewById(R.id.new_sat);
        btnupdate = findViewById(R.id.tblupdate);
        btndelete = findViewById(R.id.tbldelete);
        btnview = findViewById(R.id.tblview);

        pgawai = new Pegawai();
        dtabse = FirebaseDatabase.getInstance().getReference();
        getData();

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateData.this, TampilDataGuru.class);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //program hapus data
                if (dtabse != null ) {
                    String getKey = getIntent().getExtras().getString("getPrimaryKey");
                    dtabse.child("AbsenPegawai")
                            .child(getKey)
                            .removeValue()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(UpdateData.this, "Data Berhasil dihapus",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(UpdateData.this, TampilDataGuru.class);
                                    startActivity(intent);
                                }
                            });

                }
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Mendapatkan Data Mahasiswa yang akan dicek
                cekNIP = nipBaru.getText().toString();
                cekNama = namaBaru.getText().toString();
                cekharg = harbaru1.getText().toString();
                cekJabat = jabbaru.getText().toString();
                ceksat = satbaru.getText().toString();
                //jabbaru=jabbaru.getText().toString();

                //Mengecek agar tidak ada data yang kosong, saat proses update
                if (isEmpty(cekNama) || isEmpty(cekNama)) {
                    Toast.makeText(UpdateData.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                } else {
                    /*
                      Menjalankan proses update data.
                      Method Setter digunakan untuk mendapakan data baru yang diinputkan User.
                    */
                    Pegawai setpegawai = new Pegawai();
                    setpegawai.setKd_barang(nipBaru.getText().toString());
                    setpegawai.setNama_barang(namaBaru.getText().toString());
                    setpegawai.setJml_barang(jabbaru.getText().toString());
                    setpegawai.setHarga(harbaru1.getText().toString());
                    setpegawai.setSatuan_brg(satbaru.getText().toString());
                    updateMahasiswa(setpegawai);
                }
            }
        });
    }

        // Mengecek apakah ada data yang kosong, sebelum diupdate
        private boolean isEmpty(String s){
            return TextUtils.isEmpty(s);
        }

        //Menampilkan data yang akan di update
        private void getData(){
            //Menampilkan data dari item yang dipilih sebelumnya
            final String getnip = getIntent().getExtras().getString("dataNIP");
            final String getnama = getIntent().getExtras().getString("dataNama");
            final String getjabat = getIntent().getExtras().getString("dataJab");
            final String getSatuanb= getIntent().getExtras().getString("datasat");
            final String gethrga = getIntent().getExtras().getString("dataHar");
            nipBaru.setText(getnip);
            namaBaru.setText(getnama);
            satbaru.setText(getSatuanb);
            jabbaru.setText(getjabat);
            harbaru1.setText(gethrga);
        }

        //Proses Update data yang sudah ditentukan
        private void updateMahasiswa(Pegawai pgawai){
            String getKey = getIntent().getExtras().getString("getPrimaryKey");
            dtabse.child("AbsenPegawai")
                    .child(getKey)
                    .setValue(pgawai)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            nipBaru.setText("");
                            namaBaru.setText("");
                            satbaru.setText("");
                            jabbaru.setText("");
                            harbaru1.setText("");
                            Toast.makeText(UpdateData.this, "Data Berhasil diubah",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
        }
}