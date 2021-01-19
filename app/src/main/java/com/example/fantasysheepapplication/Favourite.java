package com.example.fantasysheepapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class Favourite extends AppCompatActivity {

    RecyclerView recyclerView_FT;
    FavouriteAdapter adapter;
    List<FavouriteAdapter> FavouriteAdapter_List;

    private static  final  String PRODUCT_URL = "http://192.168.100.17/SheepFantasyapp/favorite_rd.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        FavouriteAdapter_List = new ArrayList<>();
        recyclerView_FT= (RecyclerView) findViewById(R.id.recyclerView_FT);
        recyclerView_FT.setHasFixedSize(true);
        recyclerView_FT.setLayoutManager(new LinearLayoutManager(this));

        loadfavouriteteam();
    }

    private void loadfavouriteteam() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray favouriteConstructor = new JSONArray(response);

                    for (int i = 0; i < favouriteConstructor.length(); i++) {
                        JSONObject favouriteTeamObject = favouriteConstructor.getJSONObject(i);

                        int sheep_id = favouriteTeamObject.getInt("sheep_id");
                        String sheep_name = favouriteTeamObject.getString("sheep_name");
                        int age_id = favouriteTeamObject.getInt("age_id");
                        int breed_id = favouriteTeamObject.getInt("breed_id");
                        int gender_id = favouriteTeamObject.getInt("gender_id");
                        int point_id = favouriteTeamObject.getInt("point_id");
                        String favorite = favouriteTeamObject.getString("favorite");

                        favouriteConstructor favouriteConstructor1 = new favouriteConstructor(sheep_id, sheep_name, age_id, breed_id, gender_id, point_id, favorite);
                        FavouriteAdapter_List.add(favouriteConstructor1);

                    }
                    adapter = new FavouriteAdapter(Favourite.this, FavouriteAdapter_List);
                    recyclerView_FT.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Favourite.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);


    }
}
