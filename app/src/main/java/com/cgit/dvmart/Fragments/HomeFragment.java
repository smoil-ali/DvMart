package com.cgit.dvmart.Fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cgit.dvmart.Adapters.SectionAdapter;
import com.cgit.dvmart.Model.Section;
import com.cgit.dvmart.Model.SectionItem;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    FragmentHomeBinding binding;
    SectionAdapter adapter;
    List<Section> sectionList = new ArrayList<>();
    List<SectionItem> sectionItemList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater,container,false);
        setUpRecyclerView();
        loadSectionItemList();


        return binding.getRoot();
    }

    //setup recycler view
    private void setUpRecyclerView() {
        binding.sectionRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.sectionRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new SectionAdapter(getContext(),sectionList);
        binding.sectionRecyclerView.setAdapter(adapter);
    }

    private void loadSectionItemList(){
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

        adapter.notifyDataSetChanged();
    }
}