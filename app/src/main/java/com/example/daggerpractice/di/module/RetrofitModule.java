package com.example.daggerpractice.di.module;

import com.example.daggerpractice.data.GithubService;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

@Module
public class RetrofitModule {
    @Provides
    @Reusable
    GithubService provideGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }
}
