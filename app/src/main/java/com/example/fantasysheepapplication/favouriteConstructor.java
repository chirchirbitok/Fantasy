package com.example.fantasysheepapplication;

public class favouriteConstructor {
    private int sheep_id;
    private String sheep_name;
    private int age_id;
    private int breed_id;
    private int gender_id;
    private int point_id;
    private String favorite;



    public favouriteConstructor(int sheep_id, String sheep_name, int age_id, int breed_id, int gender_id, int point_id, String favorite) {
        this.sheep_id = sheep_id;
        this.sheep_name = sheep_name;
        this.age_id = age_id;
        this.breed_id = breed_id;
        this.gender_id = gender_id;
        this.point_id = point_id;
        this.favorite = favorite;
    }

    public int getSheep_id(){
        return sheep_id;
    }
    public String getSheep_name(){
        return sheep_name;
    }
    public int getAge_id(){
        return age_id;
    }
    public int getBreed_id(){
        return breed_id;
    }
    public int getGender_id(){
        return gender_id;
    }
    public int getPoint_id(){
        return point_id;
    }
    public String getFavorite(){
        return favorite;
    }



}
