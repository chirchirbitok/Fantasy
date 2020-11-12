package com.example.fantasysheepapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Market extends AppCompatActivity {



    private  int market_id;
    private  String market_name;
    private  String market_location;
    private int phone_number;

    public Market(int market_id, String market_name, String market_location, int phone_number){
        this.market_id = market_id;
        this.market_name = market_name;
        this.market_location = market_location;
        this.phone_number = phone_number;
    }

    public int getMarket_id(){
        return market_id;
    }
    public String getMarket_name(){
        return market_name;
    }
    public String getMarket_location(){
        return market_location;
    }
    public int getPhone_number(){
        return phone_number;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

    }




}