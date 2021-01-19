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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Purchase extends AppCompatActivity {
    RecyclerView recyclerView;
    PurchaseAdapter purchaseAdapter;
    List<PurchaseConstructor> purchaseConstructorList;

    public  static final String PRODUCT_URL = "http://192.168.100.17/SheepFantasyapp/purchase_read.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        purchaseConstructorList = new ArrayList<>();
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView24);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadPurchase();
    }

    private void loadPurchase() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray purchaseConstructors = new JSONArray(response);

                    for (int i = 0; i < purchaseConstructors.length(); i++) {
                        JSONObject purchaseObject = purchaseConstructors.getJSONObject(i);

                        int purchase_id = purchaseObject.getInt("purchase_id");
                        String purchased_item = purchaseObject.getString("purchased_item");
                        String date_of_purchase = purchaseObject.getString("date_of_purchase");
                        int price = purchaseObject.getInt("price");

                        PurchaseConstructor purchaseConstructor = new PurchaseConstructor(purchase_id, purchased_item, date_of_purchase, price);
                        purchaseConstructorList.add(purchaseConstructor);
                    }
                    purchaseAdapter = new PurchaseAdapter(Purchase.this, purchaseConstructorList);
                    recyclerView.setAdapter(purchaseAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Purchase.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}