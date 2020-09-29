package com.cgit.dvmart.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cgit.dvmart.Listeners.RightSheetCloseListener;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {


    FragmentProfileBinding binding;

    RightSheetCloseListener listener;
    public ProfileFragment() {
    }

    public void setListener(RightSheetCloseListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        binding.close.setOnClickListener(i -> {
            closeSheet();
        });

        return binding.getRoot();
    }

    private void closeSheet(){
        listener.OnClose();
    }
}