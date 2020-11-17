package com.example.daggerpractice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daggerpractice.R;
import com.example.daggerpractice.data.entity.GithubRepo;
import com.example.daggerpractice.databinding.ItemGithubRepoBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GithubRepoListAdapter extends RecyclerView.Adapter<GithubRepoListAdapter.ViewHolder> {

    private List<GithubRepo> githubRepoList = new ArrayList<>();

    @Inject
    public GithubRepoListAdapter() {

    }

    @NonNull
    @Override
    public GithubRepoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_github_repo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GithubRepoListAdapter.ViewHolder holder, int position) {
        holder.getBinding().setData(githubRepoList.get(position));
    }

    @Override
    public int getItemCount() {
        if (githubRepoList == null) return 0;
        return githubRepoList.size();
    }

    public void setList(List<GithubRepo> githubRepoList) {
        this.githubRepoList = githubRepoList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemGithubRepoBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ItemGithubRepoBinding getBinding() {
            return binding;
        }
    }
}
