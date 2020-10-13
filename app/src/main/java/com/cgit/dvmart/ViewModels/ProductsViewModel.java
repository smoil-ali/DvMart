package com.cgit.dvmart.ViewModels;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cgit.dvmart.Model.Products;
import com.cgit.dvmart.Model.Section;
import com.cgit.dvmart.Retrofit.Apis;
import com.cgit.dvmart.Retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductsViewModel extends ViewModel {

    final String TAG=ProductsViewModel.class.getSimpleName();
    Apis apis;
    private final MutableLiveData<List<Products>> repos = new MutableLiveData<>();
    private final MutableLiveData<String> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public ProductsViewModel(){
        fetchProducts();
    }

    public MutableLiveData<List<Products>> getRepos() {
        return repos;
    }

    public MutableLiveData<String> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchProducts(){
        loading.setValue(true);
        apis= RetrofitService.createService(Apis.class);
        Call<List<Products>> productsCall=apis.getAllProducts();

        Log.i(TAG,productsCall.request().url().toString());
       productsCall.enqueue(new Callback<List<Products>>() {
           @Override
           public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
               if (response.isSuccessful()){
                   Log.i(TAG," "+response.body().size());
                   repos.setValue(response.body());
                   loading.setValue(false);
               }else{
                   Log.i(TAG," "+response.message());
               }
           }

           @Override
           public void onFailure(Call<List<Products>> call, Throwable t) {
                repoLoadError.setValue(t.getMessage());
                loading.setValue(false);
               Log.i(TAG," "+t.getMessage());
           }
       });

    }
}
