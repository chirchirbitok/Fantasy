package com.example.fantasysheepapplication;

public class ProfitLossConstructor {
    private int id;
    private int total_loss;
    private int total_profit;

    public ProfitLossConstructor(int id, int total_loss, int total_profit){
        this.id = id;
        this.total_loss = total_loss;
        this.total_profit =total_profit;
    }

    public int getId(){
        return id;
    }

    public int getTotal_loss(){
        return total_loss;
    }

    public int getTotal_profit(){
        return total_profit;
    }
}
