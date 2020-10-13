package com.cgit.dvmart.Fragments;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cgit.dvmart.Adapters.HomeAdapter;
import com.cgit.dvmart.Adapters.SectionAdapter;
import com.cgit.dvmart.Adapters.SliderAdapter;
import com.cgit.dvmart.Model.Data;
import com.cgit.dvmart.Model.Products;
import com.cgit.dvmart.Model.Section;
import com.cgit.dvmart.Model.SectionItem;
import com.cgit.dvmart.Model.SliderItem;
import com.cgit.dvmart.R;
import com.cgit.dvmart.Utility.Utils;
import com.cgit.dvmart.ViewModels.ProductsViewModel;
import com.cgit.dvmart.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;

public class HomeFragment extends Fragment {


    FragmentHomeBinding binding;
    final String TAG=HomeFragment.class.getSimpleName();
    HomeAdapter adapter;
    List<Section> sectionList = new ArrayList<>();
    List<SectionItem> sectionItemList = new ArrayList<>();
    List<SliderItem> mSliderItem = new ArrayList<>();
    List<Data> dataList = new ArrayList<>();
    List<Products> productsList=new ArrayList<>();
    ProductsViewModel productsViewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater,container,false);

        productsViewModel=new ViewModelProvider(requireActivity()).get(ProductsViewModel.class);

        productsViewModel.getLoading().observe(requireActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (!aBoolean){{
                    binding.loadingView.setVisibility(View.GONE);
                    binding.homeRv.setVisibility(View.VISIBLE);
                    binding.swipeToReferesh.setRefreshing(false);
                }

                }
            }
        });

        productsViewModel.getRepoLoadError().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Utils.showDialog(getContext(),"Error",s);
                binding.swipeToReferesh.setRefreshing(false);
            }
        });


        productsViewModel.getRepos().observe(requireActivity(), new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                productsList.clear();
                dataList.add(new Data());
                Log.i(TAG,"data "+ products.size());
                sectionList.add(new Section("Shirts",products));
                Data sectionData = new Data();
                Log.i(TAG,"data "+sectionList.size());
                sectionData.setmSection(sectionList);
                dataList.add(sectionData);
                setUpRecyclerView();

                adapter.notifyDataSetChanged();
            }
        });

     /*   new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.loadingView.setVisibility(View.GONE);
                binding.homeRv.setVisibility(View.VISIBLE);
            }
        },1000);*/




        binding.swipeToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                productsViewModel.fetchProducts();
            }
        });


        return binding.getRoot();
    }

   /* private void getData(){
        dataList.add(new Data());
        Data sliderData = new Data();
        sliderData.setmSliderItem(loadSliderItem());
        dataList.add(sliderData);
        Data sectionData = new Data();


        sectionData.setmSection(loadSectionItemList());
        dataList.add(sectionData);
        adapter.notifyDataSetChanged();
    }*/

    //setup recycler view
    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.homeRv.setHasFixedSize(true);
        binding.homeRv.setLayoutManager(linearLayoutManager);
        adapter = new HomeAdapter(getActivity(),dataList);
        binding.homeRv.setAdapter(adapter);
    }

 /*   private List<Section> loadSectionItemList(){
        Uri Pic1uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic1");
        Uri Pic2uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic2");
        Uri Pic3uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic3");
        Uri Pic4uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic4");
        Uri Pic5uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic5");
        sectionItemList.add(new SectionItem(Pic1uri,"shirt1","1000"));
        sectionItemList.add(new SectionItem(Pic2uri,"shirt1","1000"));
        sectionItemList.add(new SectionItem(Pic3uri,"shirt1","1000"));
        sectionItemList.add(new SectionItem(Pic4uri,"shirt1","1000"));
        sectionItemList.add(new SectionItem(Pic5uri,"shirt1","1000"));

        sectionList.add(new Section("Shirts",sectionItemList));
        return sectionList;
    }*/

    private List<SliderItem> loadSliderItem(){
        Uri Pic1uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic1");
        Uri Pic2uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic2");
        Uri Pic3uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic3");

        mSliderItem.add(new SliderItem(Pic1uri));
        mSliderItem.add(new SliderItem(Pic2uri));
        mSliderItem.add(new SliderItem(Pic3uri));
        return mSliderItem;
    }


}