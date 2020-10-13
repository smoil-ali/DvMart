package com.cgit.dvmart.Retrofit;

import com.cgit.dvmart.Model.Product_Categories;
import com.cgit.dvmart.Model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apis {

    //http://developers.cgitsoft.com/dvmart/product_categories.php
    //Category product Api
    @GET("product_categories")
    Call<Product_Categories> getProductCategories();

    //http://developers.cgitsoft.com/dvmart/products.php
    @GET("products.php")
    Call<List<Products>> getAllProducts();




}
