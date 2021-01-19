package com.example.fantasysheepapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PurchaseAdapter extends RecyclerView.Adapter<PurchaseAdapter.PurchaseViewHolder> {
    private Context context;
    private List<PurchaseConstructor> purchaseConstructorList;

    public PurchaseAdapter(Context context, List<PurchaseConstructor> purchaseConstructorList){
        this.context = context;
        this.purchaseConstructorList = purchaseConstructorList;
    }

    @NonNull
    @Override
    public PurchaseAdapter.PurchaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.listview_purchase, null);
        PurchaseViewHolder holder = new PurchaseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseAdapter.PurchaseViewHolder holder, int position) {
        PurchaseConstructor purchaseConstructor = purchaseConstructorList.get(position);

        holder.item.setText(String.valueOf(purchaseConstructor.getPurchased_item()));
        holder.date.setText(String.valueOf(purchaseConstructor.getDate_of_purchase()));
        holder.price.setText(String.valueOf(purchaseConstructor.getPrice()));

    }

    @Override
    public int getItemCount() {
        return purchaseConstructorList.size();
    }

    public class PurchaseViewHolder extends RecyclerView.ViewHolder {
        TextView item, date, price;

        public PurchaseViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.item);
            date = itemView.findViewById(R.id.date);
            price = itemView.findViewById(R.id.price);
        }
    }
}
