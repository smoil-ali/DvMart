package com.cgit.dvmart.Adapters;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cgit.dvmart.Model.Data;
import com.cgit.dvmart.Model.Section;
import com.cgit.dvmart.Model.SliderItem;
import com.cgit.dvmart.databinding.SearchLayoutBinding;
import com.cgit.dvmart.databinding.SectionHolderBinding;
import com.cgit.dvmart.databinding.SectionLayoutBinding;
import com.cgit.dvmart.databinding.SliderLayoutBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.IllegalFormatCodePointException;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final  String TAG = HomeAdapter.class.getSimpleName();
    final int VIEW_TYPE_SLIDER=1;
    final int VIEW_TYPE_SECTION=2;
    final int VIEW_SEARCH_TYPE = 3;
    Activity activity;
    List<Data> dataList ;


    public HomeAdapter(Activity activity, List<Data> dataList) {
        this.activity = activity;
        this.dataList = dataList;
        if(dataList.size() > 0)
            Log.i(TAG,"dd"+dataList.get(0).getmSection());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder mViewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case 1:
                SliderLayoutBinding binding = SliderLayoutBinding.inflate(inflater,parent,false);
                mViewHolder = new SliderHolder(binding);
                break;
            case 2:
                SectionHolderBinding sectionLayoutBinding = SectionHolderBinding.inflate(inflater,parent,false);
                 mViewHolder = new SectionHolder(sectionLayoutBinding);
                 break;
            case 3:
                SearchLayoutBinding searchHolder = SearchLayoutBinding.inflate(inflater,parent,false);
                mViewHolder = new SearchHolder(searchHolder);
                break;
        }
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case 1:
                ((SliderHolder)holder).mBind(dataList.get(position).getmSliderItem());
                break;
            case 2:
                ((SectionHolder)holder).mBind(dataList.get(position).getmSection());
                break;
            case 3:
                ((SearchHolder)holder).mBind();
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (dataList.get(position).getmSliderItem() != null){
            type = VIEW_TYPE_SLIDER;
            return type;
        }
        if (dataList.get(position).getmSection() != null){
            type = VIEW_TYPE_SECTION;
            return type;
        }
        if (dataList.get(position).isSearch()){
            type = VIEW_SEARCH_TYPE;
            return type;
        }
        return type;
    }

    private class SliderHolder extends RecyclerView.ViewHolder {
        SliderLayoutBinding binding;
        public SliderHolder(SliderLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void mBind(List<SliderItem> sliderItem){
            SliderView sliderView;
            sliderView = binding.imageSlider;
            //have to update by usama
            /*SliderAdapter mSlideradapter = new SliderAdapter(activity,sliderItem);
            sliderView.setSliderAdapter(mSlideradapter);*/

            sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
            sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
            sliderView.setIndicatorSelectedColor(Color.WHITE);
            sliderView.setIndicatorUnselectedColor(Color.GRAY);
            sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
            sliderView.startAutoCycle();
        }
    }

    private class SectionHolder extends RecyclerView.ViewHolder{
        SectionHolderBinding binding;
        public SectionHolder(SectionHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void mBind(List<Section> section){
            Log.i(TAG,""+section.size());
            SectionAdapter adapter;
            adapter = new SectionAdapter(activity,section);
            binding.sectionRv.setAdapter(adapter);
            binding.sectionRv.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
            binding.sectionRv.setLayoutManager(linearLayoutManager);

        }
    }

    private class SearchHolder extends RecyclerView.ViewHolder {
        SearchLayoutBinding binding;
        public SearchHolder(SearchLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void mBind(){

        }
    }
}
