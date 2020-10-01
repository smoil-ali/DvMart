package com.cgit.dvmart.Model;

import java.util.List;

public class Data {
    private List<SliderItem> mSliderItem;
    private List<OfferPoster> mOfferPoster;
    private List<Section> mSection;


    public List<SliderItem> getmSliderItem() {
        return mSliderItem;
    }

    public void setmSliderItem(List<SliderItem> mSliderItem) {
        this.mSliderItem = mSliderItem;
    }

    public List<OfferPoster> getmOfferPoster() {
        return mOfferPoster;
    }

    public void setmOfferPoster(List<OfferPoster> mOfferPoster) {
        this.mOfferPoster = mOfferPoster;
    }

    public List<Section> getmSection() {
        return mSection;
    }

    public void setmSection(List<Section> mSection) {
        this.mSection = mSection;
    }

    public Data() {

    }
}
