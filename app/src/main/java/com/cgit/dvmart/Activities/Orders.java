package com.cgit.dvmart.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;

import com.cgit.dvmart.Adapters.OrderAdapter;
import com.cgit.dvmart.Model.Order;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class Orders extends AppCompatActivity {
    ActivityOrdersBinding binding;
    OrderAdapter orderAdapter;
    ArrayList<Order> orderList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setRecyclerView();
    }

    private void setRecyclerView() {
        orderList=new ArrayList<>();
        orderAdapter=new OrderAdapter(Orders.this,orderList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(Orders.this);
        binding.RvOrder.setLayoutManager(linearLayoutManager);
        binding.RvOrder.setAdapter(orderAdapter);

        orderList.add(new Order("Order NO : #102","Order Name : Order name","Total Price : INR 5500","Date 21/12/2020"));
        orderList.add(new Order("Order NO : #102","Order Name : Order name","Total Price : INR 5500","Date 21/12/2020"));
        orderList.add(new Order("Order NO : #102","Order Name : Order name","Total Price : INR 5500","Date 21/12/2020"));
        orderList.add(new Order("Order NO : #102","Order Name : Order name","Total Price : INR 5500","Date 21/12/2020"));
        orderList.add(new Order("Order NO : #102","Order Name : Order name","Total Price : INR 5500","Date 21/12/2020"));
    }
}