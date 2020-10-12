package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cgit.dvmart.Model.Shop;
import com.cgit.dvmart.Model.ShopData;
import com.cgit.dvmart.databinding.SearchLayoutBinding;
import com.cgit.dvmart.databinding.ShopItemBinding;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Shop> shopList ;

    public ShopAdapter(Context context, List<Shop> shopList) {
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

        public void mBind(Shop shop){
            Glide.with(context).load(shop.getImageUri()).into(binding.image);
            if (shop.isProduct()){
                binding.product.setVisibility(View.VISIBLE);
                binding.description.setText(shop.getDescription());
                binding.price.setText("₹"+shop.getPrice());
                binding.descountPrice.setText(shop.getDiscountPrice()+"%");
            }else {
                binding.category.setVisibility(View.VISIBLE);
                binding.categoryName.setText(shop.getmCategoryName());
                binding.cartFavContainer.setVisibility(View.GONE);
                binding.discountContainer.setVisibility(View.GONE);
            }

        }
    }




}
