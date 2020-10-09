package com.cgit.dvmart.Fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.FragmentCategoriesBinding;
import com.hamedrahimvand.merv.MervAdapter;
import com.hamedrahimvand.merv.MervClick;
import com.hamedrahimvand.merv.MervConfig;
import com.hamedrahimvand.merv.MervModel;

import java.util.ArrayList;


public class Categories extends Fragment {






    FragmentCategoriesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater,container,false);

        final MervAdapter mervAdapter = new MervAdapter(getMervs(), new MervClick.OnItemClickListener() {
            @Override
            public void OnItemClick(MervModel mervModel) {
                Toast.makeText(getContext(),mervModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        mervAdapter.setMervConfig( new MervConfig.MervConfigBuilder()
                .rotationCollapse(0)
                .rotationExpand(90)
                .sideDrawable(ContextCompat.getDrawable(getContext(),R.drawable.ic_baseline_expand_more_24))
                .textColor(ContextCompat.getColor(getContext(),R.color.colorPrimaryDark)).build());

        binding.mervView.setMervAdapter(mervAdapter);

        return binding.getRoot();

    }

    private ArrayList<MervModel> getMervs() {
        ArrayList<MervModel> mervModels = new ArrayList<>();
        MervModel home=new MervModel(0,"HOME",false,false,true);
        MervModel eshop=new MervModel(0,"ESHOP",false,false,true);
        MervModel womens = new MervModel(3,"WOMEN'S",false,true,false);
           MervModel tops=new MervModel(4,"Tops",true,false,false);
        MervModel west_wear=new MervModel(3,"WESTERN WEAR",false,true,false);
           MervModel dress=new MervModel(4,"Dress",true,false,false);
           MervModel women_tshirt=new MervModel(4,"Women T Shrits ",true,false,false);
        MervModel kurtis=new MervModel(0,"WOMEN'S KURTIS",false,false,true);

        womens.setChildList(new ArrayList<MervModel>());
        west_wear.setChildList(new ArrayList<MervModel>());


        womens.getChildList().add(tops);
        west_wear.getChildList().add(dress);
        west_wear.getChildList().add(women_tshirt);
        /*MervModel a1 = new MervModel(0,"a1",false,true,false);
        MervModel a2 = new MervModel(1,"a2",false,true,false);
        MervModel a3 = new MervModel(2,"a3",false,false,false);
        MervModel b1 = new MervModel(3,"b1",true,true,false);
        MervModel b2 = new MervModel(4,"b2",true,false,false);
        MervModel b3 = new MervModel(5,"b3",true,true,false);
        MervModel b4 = new MervModel(5,"b4",true,false,false);
        MervModel b5 = new MervModel(5,"b5",true,false,false);
        MervModel c1 = new MervModel(6,"c1",true,false,false);
        MervModel c2 = new MervModel(6,"c2",true,false,false);
        MervModel c3 = new MervModel(6,"c3",true,false,false);
        MervModel c4 = new MervModel(6,"c4",true,false,false);
        MervModel c5 = new MervModel(6,"c5",true,false,false);

        a1.setChildList(new ArrayList<MervModel>());
        a2.setChildList(new ArrayList<MervModel>());
        b1.setChildList(new ArrayList<MervModel>());
        b2.setChildList(new ArrayList<MervModel>());
        b3.setChildList(new ArrayList<MervModel>());

        b1.getChildList().add(c1);
        b1.getChildList().add(c2);
        b1.getChildList().add(c3);
        b3.getChildList().add(c1);
        b3.getChildList().add(c2);
        b3.getChildList().add(c3);
        b3.getChildList().add(c4);
        b3.getChildList().add(c5);

        a2.getChildList().add(b2);
        a2.getChildList().add(b3);
        a2.getChildList().add(b4);
        a2.getChildList().add(b5);
        a1.getChildList().add(b1);*/


        /*mervModels.add(a1);
        mervModels.add(a2);
        mervModels.add(a3);*/
        mervModels.add(home);
        mervModels.add(eshop);
        mervModels.add(womens);
        mervModels.add(west_wear);
        mervModels.add(kurtis);
        return mervModels;
    }
}