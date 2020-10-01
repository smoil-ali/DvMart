package com.cgit.dvmart.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cgit.dvmart.Model.Section;
import com.cgit.dvmart.Repository.HomeRepo;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class HomeViewModel extends ViewModel {
    final String TAG = HomeViewModel.class.getSimpleName();

    private HomeRepo mHomeRepo;
    private CompositeDisposable disposable;

    private final MutableLiveData<List<Section>> repos = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public HomeViewModel() {
        mHomeRepo = new HomeRepo();
        disposable = new CompositeDisposable();

    }

    public MutableLiveData<List<Section>> getRepos() {
        return repos;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }


}
