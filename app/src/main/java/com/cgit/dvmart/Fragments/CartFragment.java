package com.cgit.dvmart.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgit.dvmart.Adapters.CartAdapter;
import com.cgit.dvmart.Model.Cart;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.FragmentCartBinding;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    FragmentCartBinding binding;
    ArrayList<Cart> cartArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentCartBinding.inflate(inflater,container,false);
        setUpRecyclerView();
        return binding.getRoot();
    }

    private void setUpRecyclerView() {
        cartArrayList=new ArrayList<>();
        CartAdapter cartAdapter=new CartAdapter(requireContext(),cartArrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(requireContext());
        binding.cartList.setLayoutManager(linearLayoutManager);
        binding.cartList.setAdapter(cartAdapter);
        cartArrayList.add(new Cart("1",getString(R.string.smple_title),R.drawable.pic1,"description","5","$1,700.00","10"));
        cartArrayList.add(new Cart("1",getString(R.string.smple_title),R.drawable.pic2,"description","5","$1,700.00","10"));
        cartArrayList.add(new Cart("1",getString(R.string.smple_title),R.drawable.pic3,"description","5","$1,700.00","10"));
        cartArrayList.add(new Cart("1",getString(R.string.smple_title),R.drawable.pic4,"description","5","$1,700.00","10"));
        cartArrayList.add(new Cart("1",getString(R.string.smple_title),R.drawable.pic5,"description","5","$1,700.00","10"));
        cartArrayList.add(new Cart("1",getString(R.string.smple_title),R.drawable.pic1,"description","5","$1,700.00","10"));
        cartAdapter.notifyDataSetChanged();
    }
}