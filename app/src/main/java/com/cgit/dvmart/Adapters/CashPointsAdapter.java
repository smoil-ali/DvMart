package com.cgit.dvmart.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cgit.dvmart.Model.CashPoint;
import com.cgit.dvmart.databinding.ItemCashpointBinding;

import java.util.ArrayList;

public class CashPointsAdapter extends RecyclerView.Adapter<CashPointsAdapter.CashPointHolder> {
    Context context;
    ArrayList<CashPoint> cashPointArrayList;

    public CashPointsAdapter(Context context, ArrayList<CashPoint> cashPointArrayList) {
        this.context = context;
        this.cashPointArrayList = cashPointArrayList;
    }

    @NonNull
    @Override
    public CashPointHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        ItemCashpointBinding binding= ItemCashpointBinding.inflate(layoutInflater,parent,false);
        return new CashPointHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CashPointHolder holder, int position) {
        holder.bindView(cashPointArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return cashPointArrayList.size();
    }

    public class CashPointHolder extends RecyclerView.ViewHolder {
        ItemCashpointBinding binding;
        public CashPointHolder(@NonNull ItemCashpointBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
        public void bindView(CashPoint cashPoint){
            binding.eventTitle.setText(cashPoint.getEvent());
            binding.date.setText(cashPoint.getDate());
            binding.cashPoints.setText(cashPoint.getCashPints());
        }
    }
}
