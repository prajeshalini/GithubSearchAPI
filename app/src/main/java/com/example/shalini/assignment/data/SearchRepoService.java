package com.example.shalini.assignment.data;

import android.util.Log;

import com.example.shalini.assignment.ApiResult;
import com.example.shalini.assignment.data.models.ReposList;
import com.example.shalini.assignment.data.models.Repos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Shalini Prajesh on 4/3/18.
 */

public class SearchRepoService {
    SearchRepo mSearchRepo;
    private static final String TAG = "SearchRepoService";

    public SearchRepoService(SearchRepo mSearchRepo) {
        this.mSearchRepo = mSearchRepo;
    }

    public void getRepos(ApiResult apiResult){
        Call<ReposList> call = mSearchRepo.getRepoList("interview","watchers","desc",String.valueOf(10));
        call.enqueue(new Callback<ReposList>() {
            @Override
            public void onResponse(Call<ReposList> call, Response<ReposList> response) {
                List<Repos> reposList = response.body().getReposList();
                Log.e(TAG, "onResponse: "+reposList );
                apiResult.onSuccess(reposList);
            }

            @Override
            public void onFailure(Call<ReposList> call, Throwable t) {
                Log.e(TAG, "onFailure: ");
            }
        });
    }
}
