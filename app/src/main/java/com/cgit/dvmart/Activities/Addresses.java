package com.cgit.dvmart.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.cgit.dvmart.Fragments.BillingAddressFragment;
import com.cgit.dvmart.Fragments.ShippingAddressFragment;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.ActivityAddressesBinding;
import com.google.android.material.tabs.TabLayout;

public class Addresses extends AppCompatActivity {
    ActivityAddressesBinding binding;
    FragmentManager fm;
    Fragment fragment ;
    Fragment fragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddressesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragment=new BillingAddressFragment();
        fragment1=new ShippingAddressFragment();

        binding.tabLayout.addOnTabSelectedListener(tabSelectedListener);
        fm=getSupportFragmentManager();
        fm.beginTransaction().add(R.id.hostFragment,fragment1)
                .hide(fragment1).commit();
        fm.beginTransaction().add(R.id.hostFragment,fragment)
                .show(fragment).commit();

    }

    TabLayout.OnTabSelectedListener tabSelectedListener=new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getPosition()==0){
                fm.beginTransaction().hide(fragment1).show(fragment).commit();
            }else if (tab.getPosition()==1){
                fm.beginTransaction().hide(fragment).show(fragment1).commit();
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

}