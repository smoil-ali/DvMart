package com.cgit.dvmart.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgit.dvmart.Adapters.ItemAdapter;
import com.cgit.dvmart.Adapters.SliderAdapter;
import com.cgit.dvmart.Fragments.CartFragment;
import com.cgit.dvmart.Model.SliderItem;
import com.cgit.dvmart.Model.item;
import com.cgit.dvmart.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class CurrentProduct extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private SliderView sliderView;
    private SliderAdapter adapter;
    ImageButton minusButton, plusButton;
    Button btnCart;
    TextView counterValue, productName, oldPrice, newPrice;
    int countValue = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_product);

        recyclerView = findViewById(R.id.recyclerView);
        sliderView = findViewById(R.id.imageSlider);
        minusButton = findViewById(R.id.btn_decrement);
        plusButton = findViewById(R.id.btn_increment);
        counterValue = findViewById(R.id.increment_decrement_text);
        btnCart = findViewById(R.id.add_to_cart);
        productName = findViewById(R.id.product_title);
        oldPrice = findViewById(R.id.old_price);
        newPrice = findViewById(R.id.new_price);



// recylerview array
        List<item> items = new ArrayList<>();
        items.add(new item(R.drawable.pic1));
        items.add(new item(R.drawable.pic2));
        items.add(new item(R.drawable.pic3));
        items.add(new item(R.drawable.pic4));
        items.add(new item(R.drawable.pic5));

        //recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 1, recyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ItemAdapter(this, items);
        recyclerView.setAdapter(mAdapter);



        List<SliderItem> mSliderItems = new ArrayList<>();
        Uri Pic1uri = Uri.parse("android.resource://com.example.currentitem/drawable/pic1");
        Uri Pic2uri = Uri.parse("android.resource://com.example.currentitem/drawable/pic2");
        Uri Pic3uri = Uri.parse("android.resource://com.example.currentitem/drawable/pic3");
        Uri Pic4uri = Uri.parse("android.resource://com.example.currentitem/drawable/pic4");

        mSliderItems.add(new SliderItem(Pic1uri));
        mSliderItems.add(new SliderItem(Pic2uri));
        mSliderItems.add(new SliderItem(Pic3uri));
        mSliderItems.add(new SliderItem(Pic4uri));

        adapter = new SliderAdapter(this,mSliderItems);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();


        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue.setText(String.valueOf(++countValue));
                Log.d("plusButton", "onClick: button is clicked " );
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countValue > 1){
                counterValue.setText(String.valueOf(--countValue));
                Log.d("minusButton", "onClick: button is clicked " );
                }
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", productName.getText().toString());
                bundle.putString("oldPrice", oldPrice.getText().toString());
                bundle.putString("newPrice", newPrice.getText().toString());
                bundle.putInt("itemImage", items.get(0).getImage());
                bundle.putString("quantity", counterValue.getText().toString());


            }
        });
    }
}