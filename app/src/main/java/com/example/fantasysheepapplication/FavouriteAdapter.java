package com.example.fantasysheepapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteAdapterViewHolder> {
    private Context ctxx;
    private List<favouriteConstructor> favouriteConstructor_List;

    public FavouriteAdapter(Context ctxx, List<favouriteConstructor> favouriteConstructor1){
        this.ctxx = ctxx;
        this.favouriteConstructor_List = favouriteConstructor_List;
    }


    @NonNull
    @Override
    public FavouriteAdapter.FavouriteAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctxx);
        View view = layoutInflater.inflate(R.layout.listview_favourite, null);
        FavouriteAdapter.FavouriteAdapterViewHolder holder = new FavouriteAdapter.FavouriteAdapterViewHolder(view);
        return holder;
}

    @Override
    public void onBindViewHolder(@NonNull FavouriteAdapter.FavouriteAdapterViewHolder holder, int position) {
        favouriteConstructor favouriteConstructor2 = favouriteConstructor_List.get(position);

        holder.jina.setText(String.valueOf(favouriteConstructor2.getSheep_name()));
        holder.miaka.setText(String.valueOf(favouriteConstructor2.getAge_id()));
        holder.breed.setText(String.valueOf(favouriteConstructor2.getBreed_id()));
        holder.gender24.setText(String.valueOf(favouriteConstructor2.getGender_id()));
        holder.points7.setText(String.valueOf(favouriteConstructor2.getPoint_id()));

    }

    @Override
    public int getItemCount() {
        return favouriteConstructor_List.size();
    }

    public class FavouriteAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView jina, miaka, breed, gender24, points7;

        public FavouriteAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            jina = itemView.findViewById(R.id.jina);
            miaka = itemView.findViewById(R.id.miaka);
            breed = itemView.findViewById(R.id.breed);
            gender24 = itemView.findViewById(R.id.gender24);
            points7 = itemView.findViewById(R.id.points7);

        }



    }
}
