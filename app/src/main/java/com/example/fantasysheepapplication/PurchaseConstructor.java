package com.example.fantasysheepapplication;

import java.util.Date;

public class PurchaseConstructor {
    private int purchase_id;
    private String purchased_item;
    private String date_of_purchase;
    private int price;

    public PurchaseConstructor(int purchase_id, String purchased_item, String date_of_purchase, int price){
        this.purchase_id = purchase_id;
        this.purchased_item = purchased_item;
        this.date_of_purchase = date_of_purchase;
        this.price = price;
    }

    public int getPurchase_id(){
        return purchase_id;
    }

    public String getPurchased_item(){
        return purchased_item;
    }

    public String getDate_of_purchase(){
        return date_of_purchase;
    }

    public int getPrice(){
        return price;
    }

}
