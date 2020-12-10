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


public class DrinkOrder extends AppCompatActivity {
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
        setContentView(R.layout.activity_drink_order);
        recyclerView = findViewById(R.id.rvProductDrink);
        productlist = new ArrayList<>();
        btnMyOrder = findViewById(R.id.btnMyOrder);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkOrder.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkOrder.this, CartActivity.class);
                startActivity(intent);
                finishAfterTransition();
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

    protected void onSaveInstanceState(Bundle state) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        list = layoutManager.onSaveInstanceState();
        state.putParcelable(KEY, list);
        super.onSaveInstanceState(state);
    }


        private void setProductInfo() {
        productlist.add(new Product("Aqua Botol Premium","30000","20",R.drawable.aqua,30000));
        productlist.add(new Product("Jus Mangga","17000","50",R.drawable.jus_mangga,17000));
        productlist.add(new Product("Jus Anggur","20000","100",R.drawable.jus_anggur,20000));
        productlist.add(new Product("Jus Jambu","15000","55",R.drawable.jus_jambu,15000));
        productlist.add(new Product("Soda Premium","50000","55",R.drawable.soda,15000));
    }


}