package com.cgit.dvmart.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cgit.dvmart.databinding.FragmentShippingBinding;

public class ShippingAddressFragment extends Fragment {

    FragmentShippingBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentShippingBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }
}
