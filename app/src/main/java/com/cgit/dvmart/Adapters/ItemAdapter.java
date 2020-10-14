package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.cgit.dvmart.Model.Image;
import com.cgit.dvmart.Model.item;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.CurrentItemBinding;
import com.cgit.dvmart.databinding.SliderLayoutBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.CurrentItemHolder> {
    SliderLayoutBinding binding;
    Context context;
    List<Image> items;


    public ItemAdapter(Context context, List<Image> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemAdapter.CurrentItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CurrentItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.current_item,
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.CurrentItemHolder holder, int position) {
        Glide.with(context).load(items.get(position).getSrc()).into(holder.binding.currentImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CurrentItemHolder extends RecyclerView.ViewHolder {
        CurrentItemBinding binding;
        public CurrentItemHolder(@NonNull View itemView) {
            super(itemView);
            binding = CurrentItemBinding.bind(itemView);
        }
    }
}
