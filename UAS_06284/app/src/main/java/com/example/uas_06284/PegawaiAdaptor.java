package com.example.uas_06284;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PegawaiAdaptor extends RecyclerView.Adapter<PegawaiAdaptor.ViewHolder> {

    private final ArrayList<Pegawai> listpegawai;
    private final Context context;

    public PegawaiAdaptor(ArrayList<Pegawai> listpegawai, Context context) {
        this.listpegawai = listpegawai;
        this.context = context;
    }


    class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView hnip, hnama,hjabatan, hhrg, hsatuan;
        private LinearLayout ListItem;
        ViewHolder(View itemView) {
            super(itemView);
            hnip = itemView.findViewById(R.id.nopeg);
            hnama = itemView.findViewById(R.id.napeg);
            hjabatan=itemView.findViewById(R.id.jabat);
            hhrg=itemView.findViewById(R.id.Harbar);
            hsatuan=itemView.findViewById(R.id.satbar);
            ListItem = itemView.findViewById(R.id.masterdataguru);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_format_tampilan, parent,false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String nip = listpegawai.get(position).getKd_barang();
        final String nama = listpegawai.get(position).getNama_barang();
        final String jabatan=listpegawai.get(position).getJml_barang();
        final String Satuan1=listpegawai.get(position).getSatuan_brg();
        final String Hrga = listpegawai.get(position).getHarga();

        holder.hnip.setText("Kode: "+nip);
        holder.hnama.setText("Nama: "+nama);
        holder.hsatuan.setText("Satuan: "+Satuan1);
        holder.hjabatan.setText("Quantity: "+jabatan);
        holder.hhrg.setText("Harga: "+Hrga);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataNIP",listpegawai.get(position).getKd_barang());
                bundle.putString("dataNama",listpegawai.get(position).getNama_barang());
                bundle.putString("datasat",listpegawai.get(position).getSatuan_brg());
                bundle.putString("dataJab",listpegawai.get(position).getJml_barang());
                bundle.putString("dataHar",listpegawai.get(position).getHarga());

                bundle.putString("getPrimaryKey",listpegawai.get(position).getKey());
                Intent intent = new Intent(v.getContext(), UpdateData.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                return true;
            }
        });

    }


    @Override
    public int getItemCount() {

        return listpegawai.size();
    }

    public interface datalistener {
        void onDeleteData(Pegawai data, int position);
    }
    datalistener listener;
}

