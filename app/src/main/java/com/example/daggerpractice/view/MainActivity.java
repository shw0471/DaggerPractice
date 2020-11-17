package com.example.daggerpractice.view;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.daggerpractice.adapter.GithubRepoListAdapter;
import com.example.daggerpractice.databinding.ActivityMainBinding;
import com.example.daggerpractice.di.AppViewModelFactory;
import com.example.daggerpractice.viewModel.MainViewModel;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    Lazy<ActivityMainBinding> binding;
    @Inject
    AppViewModelFactory viewModelFactory;
    @Inject
    GithubRepoListAdapter githubRepoListAdapter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.get().setLifecycleOwner(this);
        binding.get().rvGithubRepoList.setAdapter(githubRepoListAdapter);
        binding.get().rvGithubRepoList.setLayoutManager(linearLayoutManager);

        mainViewModel = new ViewModelProvider(this, viewModelFactory).
                get(MainViewModel.class);
        binding.get().setViewModel(mainViewModel);

        binding.get().btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = binding.get().etSearch.getText().toString();

                if (userID.length() > 0) {
                    mainViewModel.loadRepos(userID);
                }
            }
        });

        mainViewModel.getLiveGithubRepoList().observe(this,
                githubRepos -> githubRepoListAdapter.setList(githubRepos));
    }
}