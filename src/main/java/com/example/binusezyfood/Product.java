package com.example.binusezyfood;

public class Product {
    String namaProduk;
    String Harga;
    String quantity;
    int images, sumqty, hargaproduk, TotalPay;

    public Product(String namaProduk, String harga, String quantity, int images, int hargaproduk) {
        this.namaProduk = namaProduk;
        Harga = harga;
        this.quantity = quantity;
        this.images = images;
        this.hargaproduk = hargaproduk;
    }

//    public Product(String namaProduk, String harga, String quantity, int images) {
//        this.namaProduk = namaProduk;
//        this.Harga = harga;
//        this.quantity = quantity;
//        this.images = images;
//    }


    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public int getSumqty() {
        return sumqty;
    }

    public void setSumqty(int sumqty) {
        this.sumqty = sumqty;
    }

    public int getHargaproduk() {
        return hargaproduk;
    }

    public void setHargaproduk(int hargaproduk) {
        this.hargaproduk = hargaproduk;
    }

    public int getTotalPay() {
        return TotalPay;
    }

    public void setTotalPay(int totalPay) {
        TotalPay = totalPay;
    }
}


