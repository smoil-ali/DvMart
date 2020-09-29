package com.cgit.dvmart.Model;

import android.net.Uri;

public class SectionItem {
    Uri ImageUri;
    String mProductName;
    String mProductPrice;

    public SectionItem(Uri imageUri, String mProductName, String mProductPrice) {
        ImageUri = imageUri;
        this.mProductName = mProductName;
        this.mProductPrice = mProductPrice;
    }

    public Uri getImageUri() {
        return ImageUri;
    }

    public void setImageUri(Uri imageUri) {
        ImageUri = imageUri;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public String getmProductPrice() {
        return mProductPrice;
    }

    public void setmProductPrice(String mProductPrice) {
        this.mProductPrice = mProductPrice;
    }
}
