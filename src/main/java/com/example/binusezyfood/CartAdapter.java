package com.example.binusezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private ArrayList<Product> productListCart;
    Context contex;


    public CartAdapter(ArrayList<Product> productList, Context contex){
        this.productListCart = productListCart;
        this.contex = (Context) contex;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_in_cart,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
//        String namaProduk = productListCart.get(position).namaProduk;
//        holder.namaProduk.setText(namaProduk);

        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return productListCart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView namaProduk;
        private TextView harga;
        private Button increment;
        private Button decrement;
        private TextView quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaProduk = itemView.findViewById(R.id.NamaProdukdiList);
            harga = itemView.findViewById(R.id.tvHargaList);
            increment = itemView.findViewById(R.id.btnincrement);
            quantity = itemView.findViewById(R.id.view_product_quantity);
            decrement = itemView.findViewById(R.id.btndecrement);
        }
    }
}
