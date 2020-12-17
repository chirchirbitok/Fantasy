package com.example.fantasysheepapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransferAdapter extends RecyclerView.Adapter<TransferAdapter.TransferViewHolder> {

    public Context cnt;
    public List<TransferConstructor> transferConstructorsList;

    public TransferAdapter(Context cnt, List<TransferConstructor> transferList){
        this.cnt =cnt;
        this.transferConstructorsList = transferConstructorsList;
    }
    @NonNull
    @Override
    public TransferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(cnt);
        View view = layoutInflater.inflate(R.layout.list_layout,null);
        TransferViewHolder holder =  new TransferViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransferViewHolder holder, int position) {
        TransferConstructor transferConstructor = transferConstructorsList.get(position);

        holder.sheepName.setText((String.valueOf(transferConstructor.getSheep_id())));
        holder.type_of_transfer.setText(String.valueOf(transferConstructor.getType_of_transfer()));
        holder.Price.setText(String.valueOf(transferConstructor.getPrice()));

    }

    @Override
    public int getItemCount() {
        return transferConstructorsList.size();
    }

    public class TransferViewHolder extends RecyclerView.ViewHolder {
        TextView sheepName, type_of_transfer, Price;

        public TransferViewHolder(@NonNull View itemView) {
            super(itemView);

            sheepName = itemView.findViewById(R.id.sheepName);
            type_of_transfer = itemView.findViewById(R.id.type_of_transfer);
            Price = itemView.findViewById(R.id.Price);
        }
    }
}
