package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cgit.dvmart.Model.Product_Categories;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.ShopItemBinding;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Product_Categories> shopList ;

    public ShopAdapter(Context context, List<Product_Categories> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ShopItemBinding binding = ShopItemBinding.inflate(inflater,parent,false);
        return new ShopHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ShopHolder)holder).mBind(shopList.get(position));
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    private class ShopHolder extends RecyclerView.ViewHolder{
        ShopItemBinding binding;
        public ShopHolder(ShopItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void mBind(Product_Categories product_categories){
            Glide.with(context).load(product_categories.getImage().getSrc()).into(binding.image);
            if (false){
                binding.product.setVisibility(View.VISIBLE);

            }else {
                binding.category.setVisibility(View.VISIBLE);
                binding.categoryName.setText(product_categories.getName());
                binding.cartFavContainer.setVisibility(View.GONE);
                binding.discountContainer.setVisibility(View.GONE);
            }

        }
    }




}
