package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cgit.dvmart.Activities.CurrentProduct;
import com.cgit.dvmart.Model.Products;
import com.cgit.dvmart.Model.SectionItem;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.SectionItemBinding;


import java.util.List;

public class SectionItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Products> sectionItems;

    public SectionItemAdapter(Context context, List<Products> sectionItems) {
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

        public void bindView(Products section){

            Log.i("imgrul"," "+section.getImages().get(0).getName());
            Glide.with(context).load(section.getImages().get(0).getSrc()).placeholder(R.drawable.ic_launcher_background).into(binding.productImage);
            binding.description.setText(section.getName());
            binding.oldPrice.setText(section.getPrice());
            binding.newPrice.setText(Html.fromHtml(section.getPrice_html()));
            binding.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, CurrentProduct.class);
                    intent.putExtra("product",section);
                    context.startActivity(intent);
                }
            });
        }
    }
}
