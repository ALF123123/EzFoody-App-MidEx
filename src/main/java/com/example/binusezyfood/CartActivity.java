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

public class CartActivity extends AppCompatActivity {

    private Button btnPayment;
    private ImageView back;
    private TextView Grandtotal;
    public static final int REQUEST_CODE_REPLY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartlist);
        btnPayment = findViewById(R.id.btnPayment);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,DrinkOrder.class);
                startActivity(intent);
            }
        });

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                finish();
                finishAfterTransition();

                Intent intent = new Intent(CartActivity.this, OrderComplete.class);
                startActivity(intent);
            }
        });

        if (savedInstanceState != null){
            if(savedInstanceState.containsKey("Gtotal")){
                int Gtotal =savedInstanceState.getInt("Gtotal");
                Grandtotal.setText(Gtotal);
            }
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String Gtotal = Grandtotal.getText().toString();
        outState.putString("Gtotal", Gtotal);
    }

}
