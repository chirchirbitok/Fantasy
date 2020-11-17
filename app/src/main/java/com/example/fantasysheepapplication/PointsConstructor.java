package com.example.fantasysheepapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PointsConstructor extends AppCompatActivity {

    private int point_id;
    private int sheep_id;
    private int gender_id;
    private int number_of_births;
    private int number_of_points;

    public PointsConstructor(int point_id, int sheep_id,int gender_id,int number_of_births, int number_of_points){
        this.point_id = point_id;
        this.sheep_id = sheep_id;
        this.gender_id = gender_id;
        this.number_of_births = number_of_births;
        this.number_of_points = number_of_points;
    }

    public int getPoint_id(){
        return point_id;
    }

    public int getSheep_id(){
        return sheep_id;
    }

    public int getGender_id(){
        return gender_id;
    }

    public int getNumber_of_births(){
        return number_of_births;
    }

    public int getNumber_of_points(){
        return number_of_points;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);


    }

}
