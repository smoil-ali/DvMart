package com.cgit.dvmart.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.ActivityProfileDetailsBinding;

public class ProfileDetails extends AppCompatActivity {

    ActivityProfileDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}