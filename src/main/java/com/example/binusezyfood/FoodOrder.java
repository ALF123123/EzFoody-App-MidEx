package com.example.binusezyfood;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodOrder extends AppCompatActivity {

    private ArrayList<Product> productlist;
    private RecyclerView recyclerView;
    private ProductAdapter.RecyclerViewClickListener listener;
    private Button btnMyOrder;
    private ImageView back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order);
        recyclerView = findViewById(R.id.rvProductFood);
        productlist = new ArrayList<>();
        btnMyOrder = findViewById(R.id.btnMyOrder);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodOrder.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodOrder.this, CartActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


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
        productlist.add(new Product("Nasi Goreng Kambing","50000","20",R.drawable.nasgor_kambing,50000));
        productlist.add(new Product("Rendang Kambing","45000","50",R.drawable.jus_mangga,45000));
        productlist.add(new Product("Gule Kambing","30000","100",R.drawable.jus_anggur,30000));
        productlist.add(new Product("Telur Dadar Premium","55000","55",R.drawable.telur_dadar_spesial,55000));
        productlist.add(new Product("Mie Premium","50000","55",R.drawable.mie_premium,50000));
    }

}
