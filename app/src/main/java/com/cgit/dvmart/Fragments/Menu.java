package com.cgit.dvmart.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.FragmentMenuBinding;
import com.hamedrahimvand.merv.MervAdapter;
import com.hamedrahimvand.merv.MervClick;
import com.hamedrahimvand.merv.MervConfig;
import com.hamedrahimvand.merv.MervModel;
import com.hamedrahimvand.merv.MervView;

import java.util.ArrayList;

public class Menu extends Fragment {



    FragmentMenuBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater,container,false);

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
        MervModel todaysOffer=new MervModel(1,"TODAY'S OFFER",false,false,false);
        MervModel newArrivals=new MervModel(2,"NEW ARRIVALS",false,false,false);
        MervModel womens = new MervModel(3,"WOMEN'S",false,true,false);
            MervModel westernWear=new MervModel(4,"Western Wear",true,false,false);
            MervModel ethnic=new MervModel(5,"Ethnic",true,false,false);
            MervModel jewellery=new MervModel(6,"Jewllery",true,false,false);
            MervModel bottomWear=new MervModel(7,"Bottom Wear",true,false,false);

        MervModel mens=new MervModel(2,"MEN'S",false,false,false);
        MervModel mbl_acces=new MervModel(2,"MOBILE & ACCESSORIES",false,false,false);
        MervModel home_living=new MervModel(2,"HOME & LIVINGS",false,false,false);
        MervModel kids_babies=new MervModel(2,"KIDS & BABIES",false,false,false);
        MervModel covid=new MervModel(2,"COVID-19",false,false,false);
        MervModel login_register=new MervModel(2,"LOGIN / REGISTER",false,false,false);

       /* MervModel a2 = new MervModel(1,"a2",false,true,false);
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
        MervModel c5 = new MervModel(6,"c5",true,false,false);*/

        womens.setChildList(new ArrayList<MervModel>());
        womens.getChildList().add(westernWear);
        womens.getChildList().add(ethnic);
        womens.getChildList().add(jewellery);
        womens.getChildList().add(bottomWear);
    /*    a2.setChildList(new ArrayList<MervModel>());
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
        womens.getChildList().add(b1);*/

        mervModels.add(home);
        mervModels.add(todaysOffer);
        mervModels.add(newArrivals);
        mervModels.add(womens);
        mervModels.add(mens);
        mervModels.add(mbl_acces);
        mervModels.add(home_living);
        mervModels.add(kids_babies);
        mervModels.add(covid);
        mervModels.add(login_register);
      /*  mervModels.add(a2);
        mervModels.add(a3);*/

        return mervModels;
    }
}