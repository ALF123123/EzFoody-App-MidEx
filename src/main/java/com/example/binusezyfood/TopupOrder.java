package com.example.binusezyfood;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopupOrder extends AppCompatActivity {

    private ArrayList<Product> productlist;
    private RecyclerView recyclerView;
    private ProductAdapter.RecyclerViewClickListener listener;
    private Button btnMyOrder;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_order);
        recyclerView = findViewById(R.id.rvProductTopup);
        productlist = new ArrayList<>();
        btnMyOrder = findViewById(R.id.btnMyOrder);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopupOrder.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopupOrder.this, CartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        setProductInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnClick();
        ProductAdapter adapter = new ProductAdapter(productlist, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClick() {
        listener = new ProductAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailProduct.class);
                intent.putExtra("Produk",productlist.get(position).getNamaProduk());
                intent.putExtra("harga",productlist.get(position).getHarga());
                intent.putExtra("gambar",(int)productlist.get(position).getImages());
                startActivity(intent);
            }
        };
    }

    private void setProductInfo() {
        productlist.add(new Product("E-Toll","20000","20",R.drawable.etoll,20000));
        productlist.add(new Product("OVO","20000","50",R.drawable.ovo,20000));
        productlist.add(new Product("Gopay","20000","100",R.drawable.gopay,20000));
    }
}
