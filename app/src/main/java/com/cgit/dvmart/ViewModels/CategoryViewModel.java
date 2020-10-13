package com.cgit.dvmart.ViewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cgit.dvmart.Model.Product_Categories;
import com.cgit.dvmart.Retrofit.Apis;
import com.cgit.dvmart.Retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends ViewModel {

    final String TAG = CategoryViewModel.class.getSimpleName();
    private final MutableLiveData<List<Product_Categories>> repos = new MutableLiveData<>();
    private final MutableLiveData<String> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public CategoryViewModel() {
        fetchData();
    }

    public MutableLiveData<List<Product_Categories>> getRepos() {
        return repos;
    }

    public MutableLiveData<String> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void refresh(){
        fetchData();
    }


    private void fetchData(){
        loading.setValue(true);
        Apis apis = RetrofitService.createService(Apis.class);
        Call<List<Product_Categories>> categoriesCall =apis.getProductCategories();
        Log.i(TAG,categoriesCall.request().url().toString());
        categoriesCall.enqueue(new Callback<List<Product_Categories>>() {
            @Override
            public void onResponse(Call<List<Product_Categories>> call, Response<List<Product_Categories>> response) {
                if (response.isSuccessful()){
                    loading.setValue(false);
                    repos.setValue(response.body());
                }else {
                    loading.setValue(false);
                    repoLoadError.setValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Product_Categories>> call, Throwable t) {
                repoLoadError.setValue(t.getMessage());
                loading.setValue(false);
            }
        });

    }
}
