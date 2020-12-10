package com.example.binusezyfood;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class OrderComplete extends AppCompatActivity {

    private Button btnbackmenu;
    private ImageView back;

    private TextView Grandtotal2;
    public static final int REQUEST_CODE_REPLY = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_complete);
        Grandtotal2 = findViewById(R.id.grandTotal);

        btnbackmenu = findViewById(R.id.BacktoMenu);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderComplete.this,CartActivity.class);
                startActivity(intent);
            }
        });

        btnbackmenu.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderComplete.this, MainActivity.class);
                startActivity(intent);
                finishAfterTransition();
                finish();


            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String Gtotal = Grandtotal2.getText().toString();
        outState.putString("Gtotal", Gtotal);
    }
}
