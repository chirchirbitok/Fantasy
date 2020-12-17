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

public class BoughtSheep extends AppCompatActivity {
    RecyclerView recyclerView2;
    TransferAdapter adapter;
    List<TransferConstructor> transferConstructorList;

    private static  final  String PRODUCT_URL = "http://192.168.100.17/SheepFantasyapp/transferRead.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bought_sheep);

        transferConstructorList = new ArrayList<>();
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        LoadTransfers();

    }

    private void LoadTransfers() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray transfersConstructors = new JSONArray(response);

                    for (int i=0; i<transfersConstructors.length(); i++ ){
                        JSONObject transferObject = transfersConstructors.getJSONObject(i);

                        int transfer_id = transferObject.getInt("transfer_id");
                        int sheep_id = transferObject.getInt("sheep_id");
                        String type_of_transfer = transferObject.getString("type_of_transfer");
                        int price = transferObject.getInt("price");

                        TransferConstructor transferConstructor = new TransferConstructor(transfer_id, sheep_id, type_of_transfer, price);
                        transferConstructorList.add(transferConstructor);
                    }

                    adapter = new TransferAdapter(BoughtSheep.this, transferConstructorList);
                    recyclerView2.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BoughtSheep.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}