package com.cgit.dvmart.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cgit.dvmart.Model.Image;
import com.cgit.dvmart.Model.SliderItem;
import com.cgit.dvmart.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH>  {

    private Context context;
    private List<Image> mSliderItems = new ArrayList<>();


    public void renewItems(List<Image> sliderItems) {
        this.mSliderItems = sliderItems;
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
    }


    public SliderAdapter(Context context, List<Image> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        Image sliderItem = mSliderItems.get(position);

        Glide.with(viewHolder.itemView)
                .load(sliderItem.getSrc())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;


        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.image);
            this.itemView = itemView;
        }
    }
}
