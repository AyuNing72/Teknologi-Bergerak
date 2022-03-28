package com.example.responsi_71221;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabasesHelper extends SQLiteOpenHelper {
    public final static String name_Db="DB_KHS";
    public final static String name_tbl="KHS_MHS";

    public final static String field_1="Kode";
    public final static String field_2="MKuliah";
    public final static String field_3="SKs";
    public final static String field_4="N_angka";
    public final static String field_5="N_Hruf";
    //public final static String field_6="Predikat";

    public DatabasesHelper (Context context){
        super(context,name_Db, null, 1);
        SQLiteDatabase Db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase Db) {
        Db.execSQL(" create table "+name_tbl+"(kode text primary key, Mkuliah text, " +
                "SKs text, N_angka text, N_Hruf text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int oldVersion, int newVersion) {
        Db.execSQL("DROP TABLE IF EXIST"+name_tbl);
        onCreate(Db);

    }


    public void Tambah_data(String xkode, String xMkuliah, String xSKS, String xN_Angka, String xN_Huruf) {
        SQLiteDatabase Db=this.getWritableDatabase();
        ContentValues cvalues=new ContentValues();
        cvalues.put(field_1,xkode);
        cvalues.put(field_2,xMkuliah);
        cvalues.put(field_3,xSKS);
        cvalues.put(field_4,xN_Angka);
        cvalues.put(field_5, xN_Huruf);

        Db.insert(name_tbl, null,cvalues);
    }

    public Cursor baca_dta() {
        SQLiteDatabase Db=this.getWritableDatabase();
        Cursor r=Db.rawQuery(" select * from "+name_tbl,null);
        return r;
    }

    public void updte_dta(String toString, String toString1, String toString2, String toString3, String toString4) {
        SQLiteDatabase Db=this.getWritableDatabase();
        ContentValues contentVls=new ContentValues();

        contentVls.put(field_1,toString);
        contentVls.put(field_2,toString1);
        contentVls.put(field_3,toString2);
        contentVls.put(field_4,toString3);
        contentVls.put(field_5,toString4);


        Db.update(name_tbl,contentVls,"Kode=?",new String[] {toString});

    }

    public void hapus_data(String toString) {
        SQLiteDatabase Db=getWritableDatabase();
        Db.delete(name_tbl,"Kode=?", new String[] {toString});
    }
}
