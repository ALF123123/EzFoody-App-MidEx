package com.example.binusezyfood;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyHolder> {
    private ArrayList<Product> productlist;
    private RecyclerViewClickListener listener;
    public final static String LIST_STATE_KEY = "recycler_list";
    Parcelable list;

    public ProductAdapter(ArrayList<Product> productlist, RecyclerViewClickListener listener){
        this.productlist = productlist;
        this.listener = listener;
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameProduct;
        private TextView Harga;
        private ImageView Gambar;
        private Button increment;
        private Button decrement;
        final private TextView viewqty;

        public MyHolder(final View view){
            super(view);
            nameProduct = view.findViewById(R.id.tvNamaProduk);
            Harga = view.findViewById(R.id.tvHarga);
            Gambar = view.findViewById(R.id.listGambar);
            increment = view.findViewById(R.id.btnincrement);
            decrement = view.findViewById(R.id.btndecrement);
            viewqty = view.findViewById(R.id.view_product_quantity);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ProductAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_drink_menu,parent,false);
        return  new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Product product = productlist.get(position);
        holder.nameProduct.setText(product.getNamaProduk());
        holder.Harga.setText(product.getHarga());
        holder.Gambar.setImageResource(product.getImages());
    }


    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }
}
