package com.cgit.dvmart.Model;

import android.net.Uri;

public class SliderItem {
    Uri ImageUri;

    public SliderItem(Uri imageUri) {
        ImageUri = imageUri;
    }

    public Uri getImageUri() {
        return ImageUri;
    }

    public void setImageUri(Uri imageUri) {
        ImageUri = imageUri;
    }
}
