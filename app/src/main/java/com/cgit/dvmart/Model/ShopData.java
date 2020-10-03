package com.cgit.dvmart.Model;

import java.util.List;

public class ShopData {
    List<Shop> shopList ;
    private boolean Search=true;

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public boolean isSearch() {
        return Search;
    }

    public void setSearch(boolean search) {
        Search = search;
    }
}
