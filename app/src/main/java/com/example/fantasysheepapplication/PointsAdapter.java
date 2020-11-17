package com.example.fantasysheepapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.PointsViewHolder> {

    private Context mCnt;
    private List<PointsConstructor>  pointsConstructorList;

    public PointsAdapter(Context mCnt, List<PointsConstructor>  pointsConstructorList  ){
        this.mCnt = mCnt;
        this.pointsConstructorList = pointsConstructorList;
    }



    @NonNull
    @Override
    public PointsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mCnt);
        View view = layoutInflater.inflate(R.layout.listview_card, null);
        PointsViewHolder holder = new PointsViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull PointsViewHolder holder, int position) {

        PointsConstructor pointsConstructor = pointsConstructorList.get(position);

        holder.textViewName.setText(pointsConstructor.getSheep_id());
        holder.textViewGender.setText(pointsConstructor.getGender_id());
        holder.textViewBirth.setText(pointsConstructor.getNumber_of_births());
        holder.textViewPoints.setText(pointsConstructor.getNumber_of_points());

    }

    @Override
    public int getItemCount() {
        return pointsConstructorList.size();
    }

    public class PointsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewGender , textViewBirth, textViewPoints;


        public PointsViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewGender = itemView.findViewById(R.id.textViewGender);
            textViewBirth = itemView.findViewById(R.id.textViewBirth);
            textViewPoints = itemView.findViewById(R.id.textViewPoints);
        }
    }
}
