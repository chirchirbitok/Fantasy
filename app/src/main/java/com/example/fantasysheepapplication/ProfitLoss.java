package com.example.fantasysheepapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProfitLoss extends AppCompatActivity {
    RecyclerView recyclerProfitLoss;
    ProfitLossAdapter adapter;
    List<ProfitLossConstructor> profitLossConstructorList;

    private static  final  String PRODUCT_URL = "http://192.168.100.17/SheepFantasyapp/profit_and_loss_rd.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_loss);

        profitLossConstructorList = new ArrayList<>();
        //recyclerProfitLoss = (RecyclerView) findViewById(R.id.recyclerProfitLoss);
        recyclerProfitLoss.setHasFixedSize(true);
        recyclerProfitLoss.setLayoutManager(new LinearLayoutManager(this));

        loadProfitLoss();

    }

    private void loadProfitLoss() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray ProfitLossConstructors = new JSONArray(response);

                    for (int i = 0; i < ProfitLossConstructors.length(); i++) {
                        JSONObject profitlossObject = ProfitLossConstructors.getJSONObject(i);

                        int id = profitlossObject.getInt("id");
                        int total_loss = profitlossObject.getInt("total_loss");
                        int total_profit = profitlossObject.getInt("total_profit");


                        ProfitLossConstructor profitLossConstructor = new ProfitLossConstructor(id, total_loss, total_profit);

                        profitLossConstructorList.add(profitLossConstructor);
                    }
                    adapter = new ProfitLossAdapter(ProfitLoss.this, profitLossConstructorList);
                    recyclerProfitLoss.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProfitLoss.this, error.getMessage(), Toast.LENGTH_SHORT);

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}