package com.example.fantasysheepapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TransferConstructor extends AppCompatActivity {
    private int transfer_id;
    private int sheep_id;
    private String type_of_transfer;
    private int price;

    public TransferConstructor(int transfer_id,int sheep_id, String type_of_transfer, int price){
        this.transfer_id = transfer_id;
        this.sheep_id = sheep_id;
        this.type_of_transfer = type_of_transfer;
        this.price = price;
    }

    public int getTransfer_id() {
        return transfer_id;
    }

    public int getSheep_id() {
        return sheep_id;
    }

    public String getType_of_transfer(){
        return type_of_transfer;
    }

    public int getPrice() {
        return price;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bought_sheep);


    }


}
