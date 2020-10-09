package com.cgit.dvmart.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cgit.dvmart.Activities.Addresses;
import com.cgit.dvmart.Activities.CashPoints;
import com.cgit.dvmart.Activities.Downloads;
import com.cgit.dvmart.Activities.Orders;
import com.cgit.dvmart.Activities.ProfileDetails;
import com.cgit.dvmart.Model.Order;
import com.cgit.dvmart.databinding.FragmentAccountBinding;
import com.cgit.dvmart.databinding.FragmentCartBinding;



public class AccountFragment extends Fragment {
    FragmentAccountBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentAccountBinding.inflate(inflater,container,false);
        binding.Addresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), Addresses.class));
            }
        });
        binding.accountDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), ProfileDetails.class));
            }
        });
        binding.logout.setOnClickListener(v -> new AlertDialog.Builder(requireContext())
                .setTitle("Alert")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    dialog.dismiss();
                }).setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                }).create().show());


        binding.Downloads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), Downloads.class));
            }
        });

        binding.Orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), Orders.class));
            }
        });

        binding.cashPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), CashPoints.class));
            }
        });
        return binding.getRoot();
    }


}
