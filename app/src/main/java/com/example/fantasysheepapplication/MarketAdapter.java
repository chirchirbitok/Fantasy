package com.example.fantasysheepapplication;


import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

/*
* recycler view. adapter --->binds the data to the view
* and recyclerview . view holder ---> it holds the view
*
*
* */
public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder>{


    private Context mCtx;
    private List<Market> marketList;

    public MarketAdapter(Context mCtx, List<Market> marketList) {
        this.mCtx = mCtx;
        this.marketList = marketList;
    }

        @NonNull
        @Override
    public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
            View view = layoutInflater.inflate(R.layout.list_layout,null);
            MarketViewHolder holder = new MarketViewHolder(view);
            return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MarketViewHolder holder, int position) {
        Market market =   marketList.get(position);

        holder.textViewTitle.setText(market.getMarket_name());
        holder.textViewLocation.setText(market.getMarket_location());
        holder.textViewPhoneNumber.setText(String.valueOf(market.getPhone_number()));

    }

    @Override
    public int getItemCount() {
        return marketList.size();
    }

    class MarketViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewLocation, textViewPhoneNumber;



        public MarketViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewLocation = itemView.findViewById(R.id.textViewLocation);
            textViewPhoneNumber = itemView.findViewById(R.id.textViewPhoneNumber);
        }
    }
}
