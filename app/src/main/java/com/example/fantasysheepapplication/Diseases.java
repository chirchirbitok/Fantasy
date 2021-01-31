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

public class Diseases extends AppCompatActivity {
    RecyclerView recyclerView;
    DiseasesAdapter adapter;
    List<DiseaseConstructor> diseaseConstructorList;

    private static  final  String PRODUCT_URL = "http://192.168.100.17/SheepFantasyapp/disease_rd.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);

        diseaseConstructorList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerDisease);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadDisease();

    }

    private void loadDisease() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray DiseaseConstructors = new JSONArray(response);

                    for (int i = 0; i < DiseaseConstructors.length(); i++) {
                        JSONObject jsonObject = DiseaseConstructors.getJSONObject(i);

                        int drug_id = jsonObject.getInt("drug_id");
                        String drug_name = jsonObject.getString("drug_name");
                        int disease_id = jsonObject.getInt("disease_id");

                        DiseaseConstructor diseaseConstructor = new DiseaseConstructor(drug_id, drug_name, disease_id);

                        diseaseConstructorList.add(diseaseConstructor);

                    }
                    adapter = new DiseasesAdapter(Diseases.this, diseaseConstructorList);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Diseases.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}