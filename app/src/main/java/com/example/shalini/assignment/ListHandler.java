package com.example.shalini.assignment;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.shalini.assignment.RepoDetails.RepoDetailsActivity;
import com.example.shalini.assignment.data.models.Repos;

import static com.example.shalini.assignment.AppConstants.EXTRA_REPO;

/**
 * Created by Shalini Prajesh on 5/3/18.
 */

public class ListHandler {
    private static final String TAG = "ListHandler";


    public void onClickRepo(View view, Repos repos) {
        //navigate to
        Log.e(TAG, "onClickRepo:"+repos.getOwner().getAvatarUrl());
        Intent intent = new Intent(view.getContext(), RepoDetailsActivity.class);

        intent.putExtra(EXTRA_REPO,repos);
        view.getContext().startActivity(intent);
    }
}
