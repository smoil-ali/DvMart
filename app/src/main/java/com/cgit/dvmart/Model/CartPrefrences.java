package com.cgit.dvmart.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPrefrences {
    public static final String PreferenceName = "CartPreference";
    public static final String CartProduct = "CartProducts";

    public CartPrefrences() {
        super();
    }

    public void saveCartProducts(Context context, List<Cart> cartProducts) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getApplicationContext().getSharedPreferences(PreferenceName, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonCartProducts = gson.toJson(cartProducts);
        editor.putString(CartProduct, jsonCartProducts);
        editor.commit();

    }

    public void addCartProduct(Context context, Cart cart){
        List<Cart> cartProducts = getCartProducts(context);
        if (cartProducts == null)
            cartProducts = new ArrayList<Cart>();
        cartProducts.add(cart);
        saveCartProducts(context, cartProducts);
    }

    public void removeCartProduct(Context context, Cart cart) {
        ArrayList<Cart> cartProducts = getCartProducts(context);
        if (cartProducts != null) {
            cartProducts.remove(cart);
            saveCartProducts(context, cartProducts);
        }
    }
    public ArrayList<Cart> getCartProducts(Context context){
        SharedPreferences settings;
        List<Cart> cartProducts;
        settings = context.getApplicationContext().getSharedPreferences(PreferenceName,
                Context.MODE_PRIVATE);
        if (settings.contains(CartProduct)) {
            String jsonCartProducts = settings.getString(CartProduct, null);
            Gson gson = new Gson();
            Cart[] cartItems = gson.fromJson(jsonCartProducts,
                    Cart[].class);

            cartProducts = Arrays.asList(cartItems);
            cartProducts = new ArrayList<Cart>(cartProducts);
        } else
            return null;

        return (ArrayList<Cart>) cartProducts;
    }


}

