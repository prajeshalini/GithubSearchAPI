package com.example.shalini.assignment;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.shalini.assignment.RepoDetails.ContributorsAdapter;
import com.example.shalini.assignment.contributorDetails.ContributorRepoListAdapter;
import com.example.shalini.assignment.data.models.Contributor;
import com.example.shalini.assignment.data.models.Repos;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Shalini Prajesh on 31/1/18.
 */

public class RepoListBindings {
    private static final String TAG = "UserListBindings";

    @BindingAdapter("android:items")
    public static void setRepos(RecyclerView recyclerView, List<Repos> reposList){
        Log.e(TAG, "setRepo: ");
        RepoListAdapter repoListAdapter = (RepoListAdapter) recyclerView.getAdapter();
        if (repoListAdapter != null)
        {
            Log.e(TAG, "setRepos:>>>>>>>>>>> "+repoListAdapter);
            repoListAdapter.replaceData(reposList);
        }
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }

    @BindingAdapter("android:contributors")
    public static void setContributors(RecyclerView recyclerView, List<Contributor> contributorList){
        Log.e(TAG, "setRepo: ");
        ContributorsAdapter contributorsAdapter = (ContributorsAdapter) recyclerView.getAdapter();
        if (contributorsAdapter != null)
        {
            Log.e(TAG, "setRepos:>>>>>>>>>>> "+contributorsAdapter);
            contributorsAdapter.replaceData(contributorList);
        }
    }
    @BindingAdapter("android:repolist")
    public static void setContributorsRepo(RecyclerView recyclerView,List<Repos> reposList){
        ContributorRepoListAdapter adapter = (ContributorRepoListAdapter) recyclerView.getAdapter();
        if (adapter !=null)
        {
            adapter.replaceData(reposList);
        }
    }
}
