package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cgit.dvmart.Model.Shop;
import com.cgit.dvmart.Model.ShopData;
import com.cgit.dvmart.databinding.SearchLayoutBinding;
import com.cgit.dvmart.databinding.SectionHolderBinding;
import com.cgit.dvmart.databinding.ShopItemContainerBinding;
import com.cgit.dvmart.databinding.SliderLayoutBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ShopDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    final String TAG = ShopDataAdapter.class.getSimpleName();
    final int VIEW_SEARCH_TYPE = 1;
    final int VIEW_DATA = 2;
    Context context;
    List<ShopData> shopData;

    public ShopDataAdapter(Context context, List<ShopData> shopData) {
        this.context = context;
        this.shopData = shopData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder mViewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case 1:
                SearchLayoutBinding binding = SearchLayoutBinding.inflate(inflater,parent,false);
                mViewHolder = new SearchHolder(binding);
                break;
            case 2:
                ShopItemContainerBinding shopItemContainerBinding = ShopItemContainerBinding.inflate(inflater,parent,false);
                mViewHolder = new ShopContainer(shopItemContainerBinding);
                break;
        }
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case 1:
                ((SearchHolder)holder).mBind();
                break;
            case 2:
                ((ShopContainer)holder).mBind(shopData.get(position).getShopList());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return shopData.size();
    }


    @Override
    public int getItemViewType(int position) {
        int type = 0;

        if (shopData.get(position).getShopList() != null){
            type = VIEW_DATA;
            return type;
        }
        if (shopData.get(position).isSearch()){
            type = VIEW_SEARCH_TYPE;
            return type;
        }
        return type;
    }

    private class SearchHolder extends RecyclerView.ViewHolder {
        SearchLayoutBinding binding;
        public SearchHolder(SearchLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void mBind(){

        }
    }

    private class ShopContainer extends RecyclerView.ViewHolder {
        ShopItemContainerBinding binding;
        public ShopContainer(ShopItemContainerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void mBind(List<Shop> shop){
            Log.i(TAG,shop.size()+"");
            ShopAdapter adapter;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
            binding.shopContainerRv.setHasFixedSize(true);
            binding.shopContainerRv.setLayoutManager(gridLayoutManager);
            adapter = new ShopAdapter(context,shop);
            binding.shopContainerRv.setAdapter(adapter);
        }
    }
}
