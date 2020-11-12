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

public class MainActivity2_market extends AppCompatActivity {
    RecyclerView recyclerView;
    MarketAdapter adapter;
    List<Market> marketList;

    private static  final  String PRODUCT_URL = "http://192.168.100.17/SheepFantasyapp/connection.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_market);


        marketList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMarket();
    }

    private void loadMarket(){
        StringRequest stringrequest = new StringRequest(Request.Method.GET, PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray markets = new JSONArray(response);

                            for (int i=0; i<markets.length(); i++){
                                JSONObject marketObject = markets.getJSONObject(i);

                                int market_id = marketObject.getInt("market_id");
                                String market_name = marketObject.getString("market_name");
                                String market_location = marketObject.getString("market_location");
                                int phone_number = marketObject.getInt("phone_number");

                                Market market = new Market(market_id, market_name, market_location, phone_number);

                                marketList.add(market);
                            }
                            adapter = new MarketAdapter(MainActivity2_market.this, marketList);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity2_market.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringrequest);
    }

}