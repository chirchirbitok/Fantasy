package com.example.fantasysheepapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Dream_Team_Adapter extends RecyclerView.Adapter<Dream_Team_Adapter.Dream_TeamViewHolder> {

    private Context ctx;
    private List<Dream_Team_Constructor> dream_team_constructorsList;

    public Dream_Team_Adapter(Context ctx, List<Dream_Team_Constructor> dream_team_constructors){
        this.ctx = ctx;
        this.dream_team_constructorsList = dream_team_constructorsList;
    }
    @NonNull
    @Override
    public Dream_Team_Adapter.Dream_TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.listview_dream_team, null);
        Dream_Team_Adapter.Dream_TeamViewHolder holder1 = new Dream_Team_Adapter.Dream_TeamViewHolder(view);
        return holder1;
    }

    @Override
    public void onBindViewHolder(@NonNull Dream_Team_Adapter.Dream_TeamViewHolder holder, int position) {

        Dream_Team_Constructor dream_team_constructor =  dream_team_constructorsList.get(position);

        holder.textViewName1.setText(String.valueOf(dream_team_constructor.getSheep_name()));
        holder.textViewAge.setText(String.valueOf(dream_team_constructor.getAge_id()));
        holder.textViewBreed.setText(String.valueOf(dream_team_constructor.getBreed_id()));
        holder.textViewGender.setText(String.valueOf(dream_team_constructor.getGender_id()));
        holder.textViewPoints.setText(String.valueOf(dream_team_constructor.getPoint_id()));
        holder.checkbox.setText(String.valueOf(dream_team_constructor.getFavorite()));


    }

    @Override
    public int getItemCount() {
        return dream_team_constructorsList.size();
    }

    public class Dream_TeamViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName1, textViewAge, textViewBreed, textViewGender, textViewPoints, checkbox;

        public Dream_TeamViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName1 = itemView.findViewById(R.id.textViewName1);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewBreed = itemView.findViewById(R.id.textViewBreed);
            textViewGender  = itemView.findViewById(R.id.textViewGender);
            textViewPoints = itemView.findViewById(R.id.textViewPoints);
            checkbox = itemView.findViewById(R.id.checkbox);



        }
    }
}
