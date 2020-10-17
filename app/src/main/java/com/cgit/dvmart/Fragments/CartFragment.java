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
import com.cgit.dvmart.Model.CartPrefrences;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.FragmentCartBinding;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    FragmentCartBinding binding;
    ArrayList<Cart> cartArrayList;
    CartAdapter cartAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentCartBinding.inflate(inflater,container,false);
        setUpRecyclerView();
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        CartPrefrences prefrences = new CartPrefrences();
        if (cartArrayList != null && prefrences.getCartProducts(requireContext()) != null) {
            cartArrayList.addAll(prefrences.getCartProducts(requireContext()));
            cartAdapter.notifyDataSetChanged();
        }
    }

    private void setUpRecyclerView() {
        cartArrayList=new ArrayList<>();
        cartAdapter=new CartAdapter(requireContext(),cartArrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(requireContext());
        binding.cartList.setLayoutManager(linearLayoutManager);
        binding.cartList.setAdapter(cartAdapter);


    }
}