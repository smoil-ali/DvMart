package com.cgit.dvmart.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cgit.dvmart.databinding.FragmentBillingBinding;

public class BillingAddressFragment extends Fragment {

    FragmentBillingBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding=FragmentBillingBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}
