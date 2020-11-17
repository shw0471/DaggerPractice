package com.example.daggerpractice.di.component;

import com.example.daggerpractice.di.App;
import com.example.daggerpractice.di.module.ActivityModule;
import com.example.daggerpractice.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityModule.class,
        AppModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Factory
    abstract class Factory implements AndroidInjector.Factory<App>{
    }
}