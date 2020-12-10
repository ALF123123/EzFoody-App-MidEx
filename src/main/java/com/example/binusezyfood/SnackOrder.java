package com.example.binusezyfood;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SnackOrder extends AppCompatActivity {

    private ArrayList<Product> productlist;
    private RecyclerView recyclerView;
    private ProductAdapter.RecyclerViewClickListener listener;
    private Button btnMyOrder;
    private ImageView back;
    public final static String KEY = "recycler_list";
    Parcelable list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_order);
        recyclerView = findViewById(R.id.rvProductSnack);
        productlist = new ArrayList<>();
        btnMyOrder = findViewById(R.id.btnMyOrder);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnackOrder.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnackOrder.this, CartActivity.class);
                startActivity(intent);
                finish();
            }
        });
//
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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

    protected void onSaveInstanceState(Bundle state) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        list = layoutManager.onSaveInstanceState();
        state.putParcelable(KEY, list);
        super.onSaveInstanceState(state);
    }

    private void setProductInfo() {
        productlist.add(new Product("Oreo Supreme","500000","20",R.drawable.oreo_supreme,500000));
        productlist.add(new Product("Donuts Dum Dum","80000","50",R.drawable.donat,80000));
        productlist.add(new Product("Keripik St.Erik","747000","100",R.drawable.kripik,747000));
        productlist.add(new Product("Popcorn Berco","650000","55",R.drawable.popcorn,650000));
        productlist.add(new Product("Roti Kukus","70000","55",R.drawable.roti,70000));
    }
}
