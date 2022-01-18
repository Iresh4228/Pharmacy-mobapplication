package com.example.pharmacurepharmacyapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DrugsAdapter extends RecyclerView.Adapter<DrugsAdapter.DrugsViewHolder>{

    List<Drugs> drugsList;
    Context context;

    public DrugsAdapter(List<Drugs> drugsList, Context context) {
        this.drugsList = drugsList;
        this.context = context;
    }

    @NonNull
    @Override
    public DrugsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drugs_info,parent,false);
        return new DrugsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrugsViewHolder holder, int position) {
        Drugs drugs = drugsList.get(position);
        holder.dname.setText(drugs.getPdrugname());
        holder.dprice.setText(drugs.getDrugprice().toString());
        holder.dqty.setText(drugs.getDquantity().toString());
    }

    @Override
    public int getItemCount() {
        return drugsList.size();
    }

    public class DrugsViewHolder extends  RecyclerView.ViewHolder{

        TextView dname, dprice, dqty;
        public DrugsViewHolder(@NonNull View itemView) {
            super(itemView);
            dname = itemView.findViewById(R.id.drug_info_name);
            dprice = itemView.findViewById(R.id.drug_price);
            dqty = itemView.findViewById(R.id.drug_info_qty);
        }
    }


}
