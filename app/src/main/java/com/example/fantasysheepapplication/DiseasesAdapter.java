package com.example.fantasysheepapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiseasesAdapter extends RecyclerView.Adapter<DiseasesAdapter.DiseaseViewHolder> {
    private Context context;
    private List<DiseaseConstructor> diseaseConstructorList;

    public DiseasesAdapter(Context context, List<DiseaseConstructor> diseaseConstructorList){
        this.context = context;
        this.diseaseConstructorList = diseaseConstructorList;
    }



    @NonNull
    @Override
    public DiseasesAdapter.DiseaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.listview_diseases, null);
        DiseaseViewHolder holder = new DiseaseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DiseasesAdapter.DiseaseViewHolder holder, int position) {
        DiseaseConstructor diseaseConstructor = diseaseConstructorList.get(position);

        holder.drugName.setText(String.valueOf(diseaseConstructor.getDrug_name()));
        holder.diseaseName.setText(String.valueOf(diseaseConstructor.getDisease_id()));

    }

    @Override
    public int getItemCount() {
        return diseaseConstructorList.size();
    }

    public class DiseaseViewHolder extends RecyclerView.ViewHolder {
        TextView drugName, diseaseName;

        public DiseaseViewHolder(@NonNull View itemView) {
            super(itemView);

            drugName = itemView.findViewById(R.id.drugName);
            diseaseName = itemView.findViewById(R.id.diseaseName);

        }
    }
}
