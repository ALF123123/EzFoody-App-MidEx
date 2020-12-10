package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnDrink;
    private Button btnFood;
    private Button btnSnack;
    private Button btnTopup;

    public static final int REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDrink = findViewById(R.id.btnDrink);
        btnFood = findViewById(R.id.btnFoods);
        btnSnack = findViewById(R.id.btnSnack);
        btnTopup = findViewById(R.id.btnTopup);

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TopupOrder.class);
                startActivity(intent);
                finish();
            }
        });

        btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SnackOrder.class);
                startActivity(intent);
                finish();
            }
        });

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodOrder.class);
                startActivity(intent);
                finish();
            }
        });

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrinkOrder.class);
                startActivity(intent);
                finish();
            }
        });
    }
}