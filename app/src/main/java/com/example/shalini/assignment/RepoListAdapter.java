package com.example.shalini.assignment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.shalini.assignment.data.models.Repos;
import com.example.shalini.assignment.databinding.LayoutRecyclerviewItemBinding;

import java.util.List;

;


/**
 * Created by Shalini Prajesh on 3/3/18.
 */

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.MyViewHolder> {
    private static final String TAG = "RepoListAdapter";
    private List<Repos> mRepoList;

    public RepoListAdapter(List<Repos> reposList){
        mRepoList = reposList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder: ");
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutRecyclerviewItemBinding recyclerviewItemBinding = LayoutRecyclerviewItemBinding.inflate(layoutInflater);
        return new MyViewHolder(recyclerviewItemBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Repos repo = mRepoList.get(position);
        Log.e(TAG, "onBindViewHolder: "+repo.getName()+repo.getFullName());
        holder.bind(repo);
    }

    @Override
    public int getItemCount() {
        return mRepoList != null ? mRepoList.size() : 0;
    }

    public void replaceData(List<Repos> repoList) {
        setList(repoList);
        notifyDataSetChanged();
    }

    private void setList(List<Repos> list) {
        mRepoList = list;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private final LayoutRecyclerviewItemBinding mLayoutRecyclerviewItemBinding;

        public MyViewHolder(LayoutRecyclerviewItemBinding itemView) {
            super(itemView.getRoot());
            mLayoutRecyclerviewItemBinding = itemView;
        }

        public void bind(Repos repo){
            mLayoutRecyclerviewItemBinding.setRepo(repo);
            mLayoutRecyclerviewItemBinding.setHandler(new ListHandler());
            mLayoutRecyclerviewItemBinding.executePendingBindings();
        }


    }
}
