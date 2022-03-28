package com.example.godrink;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import static android.R.string.no;
import static android.R.string.unknownName;
import static android.os.Build.VERSION_CODES.N;

public class MainActivity2 extends AppCompatActivity {

    int quantity=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void back(View view) {
        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }

    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);

        CheckBox coldChekBox= (CheckBox) findViewById(R.id.cold);
        boolean hascolddrink=coldChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Colddrink:"+hascolddrink);

        CheckBox hotCheckBox= (CheckBox) findViewById(R.id.hot);
        boolean hasHot=hotCheckBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Hot:"+hasHot);

        int price=calculateprice(hascolddrink,hasHot);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }
    public void decrement(View view){//perintah tombol Kurang
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);

        CheckBox coldChekBox= (CheckBox) findViewById(R.id.cold);
        boolean hascolddrink=coldChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Colddrink:"+hascolddrink);

        CheckBox hotCheckBox= (CheckBox) findViewById(R.id.hot);
        boolean hasHot=hotCheckBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Hot:"+hasHot);

        int price=calculateprice(hascolddrink,hasHot);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void ccold(View view) {
        CheckBox coldChekBox= (CheckBox) findViewById(R.id.cold);
        boolean hascolddrink=coldChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Colddrink:"+hascolddrink);

        CheckBox hotCheckBox= (CheckBox) findViewById(R.id.hot);
        boolean hasHot=hotCheckBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Hot:"+hasHot);

        int price=calculateprice(hascolddrink,hasHot);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void Hoot(View view) {
        CheckBox coldChekBox= (CheckBox) findViewById(R.id.cold);
        boolean hascolddrink=coldChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Colddrink:"+hascolddrink);

        CheckBox hotCheckBox= (CheckBox) findViewById(R.id.hot);
        boolean hasHot=hotCheckBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has Hot:"+hasHot);

        int price=calculateprice(hascolddrink,hasHot);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    private String createOrderSummary(int price) {
        String pricemessage="Rp. "+price;
        return  pricemessage;
    }

    private int calculateprice(boolean hasHot, boolean hascolddrink){//jumlah pesanan * harga
        int harga= 17000;

        if(hasHot){
            harga=harga+1000;//harga beda antara yang cold dan hot
        }

        if(hascolddrink){
            harga=harga+2500;
        }

        return quantity * harga;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}

