package com.cgit.dvmart.Fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgit.dvmart.Adapters.HomeAdapter;
import com.cgit.dvmart.Adapters.ShopAdapter;
import com.cgit.dvmart.Model.Shop;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.FragmentShopBinding;

import java.util.ArrayList;
import java.util.List;


public class ShopFragment extends Fragment {

    final String TAG = ShopFragment.class.getSimpleName();
    FragmentShopBinding binding;
    List<Shop> shopList = new ArrayList<>();
    ShopAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentShopBinding.inflate(inflater,container,false);

        setUpRecyclerView();

        return binding.getRoot();
    }

    private void setUpRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        binding.shopRv.setHasFixedSize(true);
        binding.shopRv.setLayoutManager(gridLayoutManager);
        adapter = new ShopAdapter(getContext(),loadData());
        binding.shopRv.setAdapter(adapter);
    }

    private List<Shop> loadData(){

        Uri Pic1uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic1");
        Uri Pic2uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic2");
        Uri Pic3uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic3");

        Shop shop = new Shop();
        shop.setImageUri(Pic1uri);
        shop.setProduct(false);
        shop.setDiscountPrice("70");
        shop.setmCategoryName("Category1");


        shopList.add(shop);

        Shop shop1 = new Shop();
        shop1.setImageUri(Pic2uri);
        shop1.setProduct(true);
        shop1.setDescription("bla bla bla blab bal bbbbbbbbbbbbbbbbb");
        shop1.setPrice("5000");
        shop1.setDiscountPrice("-10");
        shopList.add(shop1);

        Shop shop2 = new Shop();
        shop2.setImageUri(Pic3uri);
        shop2.setmCategoryName("Category3");
        shop2.setProduct(false);
        shop2.setDiscountPrice("100");
        shopList.add(shop2);

        return shopList;
    }
}