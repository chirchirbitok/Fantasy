package com.example.fantasysheepapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfitLossAdapter extends RecyclerView.Adapter<ProfitLossAdapter.ProfitLossViewHolder> {
    private Context context;
    private List<ProfitLossConstructor> profitLossConstructorsList;

    public ProfitLossAdapter (Context context, List<ProfitLossConstructor> profitLossConstructorsList ){
        this.context = context;
        this.profitLossConstructorsList = profitLossConstructorsList;
    }

    @NonNull
    @Override
    public ProfitLossViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.listview_profit_loss, null);
        ProfitLossViewHolder holder = new ProfitLossViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfitLossViewHolder holder, int position) {
        ProfitLossConstructor profitLossConstructor = profitLossConstructorsList.get(position);

        holder.total_loss.setText(String.valueOf(profitLossConstructor.getTotal_loss()));
        holder.total_profit.setText(String.valueOf(profitLossConstructor.getTotal_profit()));

    }

    @Override
    public int getItemCount() {
        return profitLossConstructorsList.size();
    }

    public class ProfitLossViewHolder extends RecyclerView.ViewHolder {
        TextView total_loss, total_profit;
        public ProfitLossViewHolder(@NonNull View itemView) {
            super(itemView);
            total_loss = itemView.findViewById(R.id.total_loss);
            total_profit = itemView.findViewById(R.id.total_profit);
        }
    }
}
