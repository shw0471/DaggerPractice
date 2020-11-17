package com.example.daggerpractice.data;

import com.example.daggerpractice.data.entity.GithubRepo;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("users/{user}/repos")
    Single<List<GithubRepo>> getGithubRepo(@Path("user") String userID);
}
