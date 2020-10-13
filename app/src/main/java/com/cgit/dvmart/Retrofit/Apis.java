package com.cgit.dvmart.Retrofit;

import com.cgit.dvmart.Model.Product_Categories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apis {

    //http://developers.cgitsoft.com/dvmart/product_categories.php
    //Category product Api
    @GET("product_categories.php")
    Call<List<Product_Categories>> getProductCategories();
}
