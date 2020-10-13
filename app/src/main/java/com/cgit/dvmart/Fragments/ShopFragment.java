package com.cgit.dvmart.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cgit.dvmart.Adapters.ShopDataAdapter;
import com.cgit.dvmart.Model.Product_Categories;
import com.cgit.dvmart.Model.ShopData;
import com.cgit.dvmart.Utility.Utils;
import com.cgit.dvmart.ViewModels.ShopViewModel;
import com.cgit.dvmart.databinding.FragmentShopBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;


public class ShopFragment extends Fragment {

    final String TAG = ShopFragment.class.getSimpleName();
    FragmentShopBinding binding;
    List<ShopData> shopList = new ArrayList<>();
    ShopDataAdapter adapter;

    ShopViewModel shopViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentShopBinding.inflate(inflater,container,false);

        setUpRecyclerView();
        shopViewModel = new ViewModelProvider(getActivity()).get(ShopViewModel.class);
        shopViewModel.getLoading().observe(requireActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Log.i(TAG,"loading "+aBoolean);
                if (!aBoolean){
                    binding.loadingView.setVisibility(View.GONE);
                    binding.refresher.setRefreshing(false);
                }
            }
        });

        shopViewModel.getRepoLoadError().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String error) {
                Log.i(TAG,error);
                binding.refresher.setRefreshing(false);
                Utils.showDialog(getContext(),"Error",error);
            }
        });

        shopViewModel.getRepos().observe(requireActivity(), new Observer<List<Product_Categories>>() {
            @Override
            public void onChanged(List<Product_Categories> product_categories_list) {
                Log.i(TAG,"data "+ product_categories_list.size());
                shopList.clear();
                ShopData shopData1 = new ShopData();
                shopData1.setSearch(true);
                shopData1.setShopList(null);
                shopList.add(shopData1);
                ShopData shopData2 = new ShopData();
                shopData2.setSearch(false);
                shopData2.setShopList(product_categories_list);
                shopList.add(shopData2);
                adapter.notifyDataSetChanged();
                binding.refresher.setRefreshing(false);
            }
        });

        binding.refresher.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                shopViewModel.refresh();
            }
        });




        return binding.getRoot();
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.shopRv.setHasFixedSize(true);
        binding.shopRv.setLayoutManager(linearLayoutManager);
        adapter = new ShopDataAdapter(getContext(),shopList);
        binding.shopRv.setAdapter(adapter);
    }


}