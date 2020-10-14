package com.cgit.dvmart.Model;

import java.util.List;

public class ShopData {
    List<Product_Categories> shopList ;
    private boolean Search=true;

    public List<Product_Categories> getShopList() {
        return shopList;
    }

    public void setShopList(List<Product_Categories> shopList) {
        this.shopList = shopList;
    }

    public boolean isSearch() {
        return Search;
    }

    public void setSearch(boolean search) {
        Search = search;
    }
}
