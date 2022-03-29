package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class input_mhs extends AppCompatActivity {
    Button tblsimpan, tblview;
    EditText xNim, xNama;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_mhs);

        xNim=findViewById(R.id.nimMHS);
        xNama=findViewById(R.id.namaMHS);

        dbh=new DatabaseHelper(this);
        tblsimpan=findViewById(R.id.Tombol_save);
        tblview=findViewById(R.id.Tombol_View);

        tblsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xNim.getText().length()<14 || xNim.getText().length()>14 )
                {
                    xNim.setError("Wajib 14 karakter");
                    Toast.makeText(getApplicationContext(),"Maaf masukan 14 karakter",Toast.LENGTH_SHORT).show();
                    xNim.requestFocus();
                } else {
                    dbh.tambah_data(xNim.getText().toString(), xNama.getText().toString());
                }
            }
        });

        tblview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(input_mhs.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}