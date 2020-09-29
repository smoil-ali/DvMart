package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cgit.dvmart.Model.SectionItem;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.SectionItemBinding;


import java.util.List;

public class SectionItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<SectionItem> sectionItems;

    public SectionItemAdapter(Context context, List<SectionItem> sectionItems) {
        this.context = context;
        this.sectionItems = sectionItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SectionItemBinding binding = SectionItemBinding.inflate(layoutInflater,parent,false);
        return new SectionItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SectionItemHolder)holder).bindView(sectionItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sectionItems.size();
    }

    private class SectionItemHolder extends RecyclerView.ViewHolder {
        SectionItemBinding binding;
        public SectionItemHolder(SectionItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(SectionItem section){
            Glide.with(context).load(section.getImageUri()).placeholder(R.drawable.ic_launcher_background).into(binding.productImage);
            binding.description.setText(section.getmProductName());
            binding.price.setText("$"+section.getmProductPrice());
        }
    }
}
