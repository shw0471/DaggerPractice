package com.example.daggerpractice.di.module;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daggerpractice.R;
import com.example.daggerpractice.databinding.ActivityMainBinding;
import com.example.daggerpractice.di.ActivityContext;
import com.example.daggerpractice.di.ActivityScope;
import com.example.daggerpractice.di.ApplicationContext;
import com.example.daggerpractice.view.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    @ActivityScope
    static ActivityMainBinding provideBinding(MainActivity activity) {
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

    @Provides
    @ActivityContext
    static Context provideContext(MainActivity activity) {
        return activity;
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(@ApplicationContext Context context) {
        return new LinearLayoutManager(context) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }
}
