package com.example.fantasysheepapplication;

public class DiseaseConstructor {
    private int drug_id;
    private String drug_name;
    private int disease_id;

    public DiseaseConstructor(int drug_id, String drug_name, int disease_id){
        this.drug_id = drug_id;
        this.drug_name = drug_name;
        this.disease_id =disease_id;
    }

    public int getDrug_id(){
        return drug_id;
    }

    public String getDrug_name(){
        return drug_name;
    }

    public int getDisease_id(){
        return disease_id;
    }
}
