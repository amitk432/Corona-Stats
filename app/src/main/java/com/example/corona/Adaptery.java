package com.example.corona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private final Context mContext ;
    private final List<ModelClass> mData;

    public Adaptery(Context mContext, List<ModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext) ;
        v = inflater.inflate(R.layout.data_items, parent, false) ;

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.region.setText(mData.get(position).getRegion());
        holder.activeCases.setText(mData.get(position).getActiveCases());
        holder.newInfected.setText(mData.get(position).getNewInfected());
        holder.recovered.setText(mData.get(position).getRecovered());
        holder.newRecovered.setText(mData.get(position).getNewRecovered());
        holder.deceased.setText(mData.get(position).getDeceased());
        holder.newDeceased.setText(mData.get(position).getNewDeceased());
        holder.totalInfected.setText(mData.get(position).getTotalInfected());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView region ;
        TextView activeCases ;
        TextView newInfected ;
        TextView recovered ;
        TextView newRecovered ;
        TextView deceased ;
        TextView newDeceased ;
        TextView totalInfected ;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            region = itemView.findViewById(R.id.region) ;
            activeCases = itemView.findViewById(R.id.activeCases) ;
            newInfected = itemView.findViewById(R.id.newInfected) ;
            recovered = itemView.findViewById(R.id.recovered) ;
            newRecovered = itemView.findViewById(R.id.newRecovered) ;
            deceased = itemView.findViewById(R.id.deceased) ;
            newDeceased = itemView.findViewById(R.id.newDeceased) ;
            totalInfected = itemView.findViewById(R.id.totalInfected) ;


        }
    }

}
