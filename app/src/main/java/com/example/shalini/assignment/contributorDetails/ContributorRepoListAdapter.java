package com.example.shalini.assignment.contributorDetails;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shalini.assignment.RepoDetails.RepoDetailsActivity;
import com.example.shalini.assignment.data.models.Repos;
import com.example.shalini.assignment.databinding.LayoutRepoItemBinding;

import java.util.List;

import static com.example.shalini.assignment.AppConstants.EXTRA_REPO;

/**
 * Created by Shalini Prajesh on 5/3/18.
 */

public class ContributorRepoListAdapter extends RecyclerView.Adapter<ContributorRepoListAdapter.MyViewHolder> {
    List<Repos> mReposList;

    public ContributorRepoListAdapter(List<Repos> mReposList) {
        this.mReposList = mReposList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutRepoItemBinding layoutRepoItemBinding = LayoutRepoItemBinding.inflate(layoutInflater);
        return new MyViewHolder(layoutRepoItemBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Repos repos = mReposList.get(position);
        holder.bind(repos);
    }

    @Override
    public int getItemCount() {
        return mReposList != null ? mReposList.size() : 0;
    }

    public void replaceData(List<Repos> reposList) {
        mReposList = reposList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        LayoutRepoItemBinding mLayoutRepoItemBinding;

        public MyViewHolder(LayoutRepoItemBinding itemView) {
            super(itemView.getRoot());
            mLayoutRepoItemBinding = itemView;
            itemView.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Repos repos = mLayoutRepoItemBinding.getRepo();
                    Intent intent = new Intent(v.getContext(), RepoDetailsActivity.class);
                    intent.putExtra(EXTRA_REPO,repos);
                    v.getContext().startActivity(intent);
                }
            });
        }
        public void bind(Repos repos){
            mLayoutRepoItemBinding.setRepo(repos);
            mLayoutRepoItemBinding.executePendingBindings();
        }
    }
}
