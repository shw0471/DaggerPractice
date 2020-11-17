package com.example.daggerpractice.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.daggerpractice.data.GithubService;
import com.example.daggerpractice.data.entity.GithubRepo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    @NonNull
    private final GithubService githubService;
    private final MutableLiveData<List<GithubRepo>> liveGithubRepoList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    @Inject
    public MainViewModel(@NonNull Application application,
                         @NonNull GithubService githubService) {
        super(application);
        this.githubService = githubService;
    }

    public void loadRepos(String userID) {
        isLoading.setValue(true);
        githubService.getGithubRepo(userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(githubRepos -> {
                    isLoading.setValue(false);
                    liveGithubRepoList.setValue(githubRepos);
                }, throwable -> {
                    GithubRepo githubRepo = new GithubRepo();
                    List<GithubRepo> githubRepoList = new ArrayList<>();

                    githubRepo.setName("Wrong ID");
                    githubRepo.setCreated_at("please check the Github ID");
                    githubRepoList.add(githubRepo);

                    isLoading.setValue(false);
                    liveGithubRepoList.setValue(githubRepoList);
                });
    }

    @NonNull
    public MutableLiveData<List<GithubRepo>> getLiveGithubRepoList() {
        return liveGithubRepoList;
    }

    @NonNull
    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}
