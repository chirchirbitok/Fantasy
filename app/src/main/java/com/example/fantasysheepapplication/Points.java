package com.example.fantasysheepapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Points extends AppCompatActivity {
    RecyclerView recyclerView1;
    PointsAdapter adapter;
    List<PointsConstructor>  pointsConstructorList;

    private static  final  String PRODUCT_URL = "http://192.168.100.17/SheepFantasyapp/connection.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        pointsConstructorList = new ArrayList<>();
        recyclerView1= (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        loadPoints();

    }

    private void loadPoints() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray pointsConstructors = new JSONArray(response);

                    for (int i = 0; i < pointsConstructors.length(); i++) {
                        JSONObject pointObject = pointsConstructors.getJSONObject(i);

                        int point_id = pointObject.getInt("point_id");
                        int sheep_id = pointObject.getInt("sheep_id");
                        int gender_id = pointObject.getInt("gender_id");
                        int number_of_births = pointObject.getInt("number_of_births");
                        int number_of_points = pointObject.getInt("number_of_points");

                        PointsConstructor pointsConstructor = new PointsConstructor(point_id, sheep_id, gender_id, number_of_births, number_of_points);

                        pointsConstructorList.add(pointsConstructor);
                    }
                    adapter = new PointsAdapter(Points.this, pointsConstructorList);
                    recyclerView1.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Points.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
    });
    }

}

