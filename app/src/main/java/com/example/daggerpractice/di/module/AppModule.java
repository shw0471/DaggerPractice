package com.example.daggerpractice.di.module;

import android.app.Application;
import android.content.Context;

import com.example.daggerpractice.di.App;
import com.example.daggerpractice.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {
        ViewModelModule.class,
        RetrofitModule.class
})
public class AppModule {

    @Provides
    @Singleton
    Application provideApp(App app) {
        return app;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext(App app) {
        return app;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
}
