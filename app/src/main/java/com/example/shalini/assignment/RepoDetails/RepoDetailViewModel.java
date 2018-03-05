package com.example.shalini.assignment.RepoDetails;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.example.shalini.assignment.data.models.Contributor;
import com.example.shalini.assignment.data.RemoteDataSource;
import com.example.shalini.assignment.data.models.Repos;
import com.example.shalini.assignment.data.SearchRepo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Shalini Prajesh on 5/3/18.
 */

public class RepoDetailViewModel {
    private static final String TAG = "RepoDetailViewModel";
    private RemoteDataSource mRemoteDataSource;
    private Repos mRepos;
    private Context mContext;
    public ObservableList<Contributor> contributorsList = new ObservableArrayList<>();

    public RepoDetailViewModel(RemoteDataSource remoteDataSource,Context context) {
        mRemoteDataSource = remoteDataSource;
        mContext = context;
    }

    public void start(Repos repos){
        mRepos = repos;
        loadContributors();
    }

    private void loadContributors() {
        SearchRepo searchRepo = mRemoteDataSource.createApiService(SearchRepo.class);
        Observable<List<Contributor>> listObservable = searchRepo.getContributorList(mRepos.getContributorsUrl());
        listObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((contributorList)->{
                    List<Contributor> contributors = new ArrayList<>();
                    for (Contributor contributor :
                            contributorList) {
                        contributors.add(contributor);
                        Log.e(TAG, "loadContributors: "+contributor.getAvatarUrl() );
                    }
                    contributorsList.addAll(contributors);
                });

    }
}
