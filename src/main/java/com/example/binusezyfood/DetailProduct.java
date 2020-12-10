package com.example.binusezyfood;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailProduct extends AppCompatActivity {

    private int qty = 0;
    private ImageView back;
    private Button ordermore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_drink );

        back = findViewById(R.id.back);
        ordermore = findViewById(R.id.ordermore);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProduct.this,DrinkOrder.class);
                startActivity(intent);
            }
        });

        ordermore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProduct.this,DrinkOrder.class);
                startActivity(intent);
                finish();
            }
        });


        TextView NamaProduk = findViewById(R.id.NamaProduk);
        TextView Harga = findViewById(R.id.Harga);
        ImageView Gambar = findViewById(R.id.GambarDetail);
        Button decrement = findViewById(R.id.btndecrement);
        Button increment = findViewById(R.id.btnincrement);
        final TextView view = findViewById(R.id.view_product_quantity);

        String Produk = "";
        String harga = "";
        ImageView gambar = null;

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            Produk=extras.getString("Produk");
            harga=extras.getString("harga");

        }

        NamaProduk.setText(Produk);
        Harga.setText(harga);
        Gambar.setImageResource(getIntent().getIntExtra("gambar",0));

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty += 1;
                view.setText(String.valueOf(qty));
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty -=1;
                if (qty < 0)
                    qty = 0;
                view.setText(String.valueOf(qty));
            }
        });

    }
}
