package com.cgit.dvmart.Model;

import android.net.Uri;

public class Cart {
    String itemId;
    String itmeName;
    int image;
    String description;
    String quantitiy;
    String price;
    String discountPrice;


    public Cart(String itemId, String itmeName, int image, String description, String quantitiy, String price, String discountPrice) {
        this.itemId = itemId;
        this.itmeName = itmeName;
        this.image = image;
        this.description = description;
        this.quantitiy = quantitiy;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItmeName() {
        return itmeName;
    }

    public void setItmeName(String itmeName) {
        this.itmeName = itmeName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(String quantitiy) {
        this.quantitiy = quantitiy;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }
}
