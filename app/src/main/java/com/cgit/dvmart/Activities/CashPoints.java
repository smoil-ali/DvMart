package com.cgit.dvmart.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.cgit.dvmart.Adapters.CashPointsAdapter;
import com.cgit.dvmart.Model.CashPoint;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.ActivityCashPointsBinding;

import java.util.ArrayList;

public class CashPoints extends AppCompatActivity {
    ActivityCashPointsBinding binding;
    CashPointsAdapter cashPointsAdapter;
    ArrayList<CashPoint> cashPointArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCashPointsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        cashPointArrayList=new ArrayList<>();
        cashPointsAdapter=new CashPointsAdapter(CashPoints.this,cashPointArrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(CashPoints.this);
        binding.rvCashPoints.setLayoutManager(linearLayoutManager);
        binding.rvCashPoints.setAdapter(cashPointsAdapter);
        cashPointArrayList.add(new CashPoint("1",getString(R.string.sample_cashpoint),"October 8, 2020","250+"));
        cashPointArrayList.add(new CashPoint("1",getString(R.string.sample_cashpoint),"October 8, 2020","250+"));
        cashPointArrayList.add(new CashPoint("1",getString(R.string.sample_cashpoint),"October 8, 2020","250+"));
        cashPointArrayList.add(new CashPoint("1",getString(R.string.sample_cashpoint),"October 8, 2020","250+"));
        cashPointArrayList.add(new CashPoint("1",getString(R.string.sample_cashpoint),"October 8, 2020","250+"));

    }
}