package com.example.daggerpractice.di;

import com.example.daggerpractice.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class App extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication>
    applicationInjector() {
        return DaggerAppComponent.factory().create(this);
    }
}