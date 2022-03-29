package com.example.sqlitemhs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String nama_db="DB_MHS";
    public final static String nama_tabel="Mahasiswa";

    public final static String field_01="nim";
    public final static String field_02="Nama_Mhs";

    public DatabaseHelper(Context context) {
        super(context, nama_db, null, 1);
        SQLiteDatabase DB=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(" create table "+nama_tabel+"(nim text primary key, Nama_Mhs text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("DROP TABLE IF EXIST"+nama_tabel);
        onCreate(DB);

    }

    public void tambah_data(String xnim, String xnama) {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field_01,xnim);
        contentValues.put(field_02,xnama);

        DB.insert(nama_tabel,null,contentValues);
    }

    public Cursor baca_dta() {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor rees=DB.rawQuery(" select * from "+nama_tabel,null);
        return rees;
    }

    public void update_data(String toString, String toString1) {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(field_01,toString);
        contentValues.put(field_02,toString1);

        DB.update(nama_tabel,contentValues,"nim=?",new String[] {toString});

    }

    public void hapus_data(String toString) {
        SQLiteDatabase DB=getWritableDatabase();
        DB.delete(nama_tabel,"nim=?",new String[] {toString});
    }
}
