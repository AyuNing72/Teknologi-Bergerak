package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_Mhs extends AppCompatActivity {

    DatabaseHelper dbh;
    EditText Tnama,Tnim;
    Button btnview,btnUpdate, btndeleted;

    String bnim="Nimnya";
    String bnama="Namanya";
    String TampungNim,TampungNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mhs);

        Tnim=findViewById(R.id.nimMHS_edt);
        Tnama=findViewById(R.id.namaMHS_edt);

        btnview=findViewById(R.id.Tombol_ViewEdt);
        btnUpdate=findViewById(R.id.Tombol_Update);
        btndeleted=findViewById(R.id.Tombol_Hapus);

        dbh=new DatabaseHelper(this);

        Bundle bundle=getIntent().getExtras();
        TampungNim=bundle.getString(bnim);
        TampungNama=bundle.getString(bnama);

        Tnim.setText(TampungNim);
        Tnama.setText(TampungNama);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh.update_data(Tnim.getText().toString(),Tnama.getText().toString());
                Toast.makeText(getApplicationContext(),"Update Sukses",Toast.LENGTH_SHORT).show();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Edit_Mhs.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btndeleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.hapus_data(Tnim.getText().toString());
                Toast.makeText(getApplicationContext(),"Data Terhapus",Toast.LENGTH_SHORT).show();
            }
        });


    }
}