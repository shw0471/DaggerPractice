package com.example.daggerpractice.di.module;

import com.example.daggerpractice.di.ActivityScope;
import com.example.daggerpractice.view.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule{

    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
