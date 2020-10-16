package com.cgit.dvmart.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cgit.dvmart.Adapters.ItemAdapter;
import com.cgit.dvmart.Adapters.SliderAdapter;
import com.cgit.dvmart.Model.Cart;
import com.cgit.dvmart.Model.CartPrefrences;
import com.cgit.dvmart.Model.Products;
import com.cgit.dvmart.Model.SliderItem;
import com.cgit.dvmart.Model.item;
import com.cgit.dvmart.R;
import com.cgit.dvmart.databinding.ActivityCurrentProductBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class CurrentProduct extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Cart cart;
    Products products;
    Button btnCart;

    private SliderView sliderView;
    private SliderAdapter adapter;
    ActivityCurrentProductBinding binding;
    int countValue=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCurrentProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = findViewById(R.id.recyclerView);
        sliderView = findViewById(R.id.imageSlider);
        btnCart  = findViewById(R.id.add_to_cart);

        products= (Products) getIntent().getExtras().get("product");

        setUperSlider(products);
        setLowerSlider(products);
        setProductData(products);

        binding.container.btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.container.incrementDecrementText.setText(String.valueOf(++countValue));
                Log.d("plusButton", "onClick: button is clicked " );
            }
        });

        binding.container.btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countValue > 1){
                    binding.container.incrementDecrementText.setText(String.valueOf(--countValue));
                    Log.d("minusButton", "onClick: button is clicked " );
                }
            }
        });


        binding.container.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart cart = new Cart();
                cart.setItmeName(products.getName());
                cart.setItemId(products.getId());


                CartPrefrences prefrences = new CartPrefrences();
                prefrences.addCartProduct(CurrentProduct.this,cart);
            }
        });

    }



    private void setProductData(Products products) {
        binding.container.productTitle.setText(products.getName());
        binding.container.aboutProduct.setText(products.getShort_description());
        binding.container.rating.setRating(Float.parseFloat(products.getAverage_rating()));
        binding.container.customerReview.setText(String.valueOf(products.getRating_count()));
        binding.container.deliveryTime.setText(products.getDate_on_sale_to());
        binding.container.newPrice.setText(Html.fromHtml(products.getPrice_html()));
        binding.container.oldPrice.setText(Html.fromHtml(products.getPrice_html()));
        binding.container.catTitle.setText(products.getCategories().get(0).getName());
        binding.container.tagTitle.setText(products.getTags().get(0).getName());
        binding.container.skuTitle.setText(products.getSku());

    }

    private void setLowerSlider(Products products) {

        /*
        List<item> items = new ArrayList<>();
        items.add(new item(R.drawable.pic1));
        items.add(new item(R.drawable.pic2));
        items.add(new item(R.drawable.pic3));
        items.add(new item(R.drawable.pic4));
        items.add(new item(R.drawable.pic5));*/

        //recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 1, recyclerView.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        Log.i("size iamges list"," "+products.getImages().size());
        mAdapter = new ItemAdapter(this, products.getImages());
        recyclerView.setAdapter(mAdapter);
    }


    public void setUperSlider(Products products){


     /*   List<SliderItem> mSliderItems = new ArrayList<>();
        Uri Pic1uri = Uri.parse("android.resource://com.example.currentitem/drawable/pic1");
        Uri Pic2uri = Uri.parse("android.resource://com.example.currentitem/drawable/pic2");
        Uri Pic3uri = Uri.parse("android.resource://com.example.currentitem/drawable/pic3");
        Uri Pic4uri = Uri.parse("android.resource://com.example.currentitem/drawable/pic4");

        mSliderItems.add(new SliderItem(Pic1uri));
        mSliderItems.add(new SliderItem(Pic2uri));
        mSliderItems.add(new SliderItem(Pic3uri));
        mSliderItems.add(new SliderItem(Pic4uri));*/


        adapter = new SliderAdapter(this,products.getImages());

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }


}