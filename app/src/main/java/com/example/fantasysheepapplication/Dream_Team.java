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

public class Dream_Team extends AppCompatActivity {

    RecyclerView recyclerView_DT;
    Dream_Team_Adapter adapter;
    List<Dream_Team_Constructor> Dream_Team_Constructor_List;

    private static  final  String PRODUCT_URL = "http://192.168.100.17/SheepFantasyapp/DreamTeam_Read.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream__team);

        Dream_Team_Constructor_List = new ArrayList<>();
        recyclerView_DT=(RecyclerView) findViewById(R.id.recyclerView_DT);
        recyclerView_DT.setHasFixedSize(true);
        recyclerView_DT.setLayoutManager(new LinearLayoutManager(this));

        loadDreamTeam();
    }

    private void loadDreamTeam() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray Dream_Team_Constructor = new JSONArray(response);

                    for (int i = 0; i < Dream_Team_Constructor.length(); i++) {
                        JSONObject DreamTeamObject = Dream_Team_Constructor.getJSONObject(i);

                        int sheep_id = DreamTeamObject.getInt("sheep_id");
                        String sheep_name = DreamTeamObject.getString("sheep_name");
                        int age_id = DreamTeamObject.getInt("age_id");
                        int breed_id = DreamTeamObject.getInt("breed_id");
                        int gender_id = DreamTeamObject.getInt("gender_id");
                        int point_id = DreamTeamObject.getInt("point_id");
                        String favorite = DreamTeamObject.getString("favorite");

                        Dream_Team_Constructor dream_team_constructor = new Dream_Team_Constructor(sheep_id, sheep_name, age_id,breed_id, gender_id, point_id, favorite);
                        Dream_Team_Constructor_List.add(dream_team_constructor);
                    }
                    adapter = new Dream_Team_Adapter(Dream_Team.this, Dream_Team_Constructor_List);
                    recyclerView_DT.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Dream_Team.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}