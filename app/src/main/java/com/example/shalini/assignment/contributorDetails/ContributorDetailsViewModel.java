package com.example.shalini.assignment.contributorDetails;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.example.shalini.assignment.data.RemoteDataSource;
import com.example.shalini.assignment.data.SearchRepo;
import com.example.shalini.assignment.data.models.Contributor;
import com.example.shalini.assignment.data.models.Repos;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Shalini Prajesh on 5/3/18.
 */

public class ContributorDetailsViewModel {
    private RemoteDataSource remoteDataSource;
    public ObservableList<Repos> reposObservableList = new ObservableArrayList<>();

    public ContributorDetailsViewModel(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void start(Contributor contributor){
        loadRepos(contributor.getRepoUrl());
    }

    private void loadRepos(String repoUrl) {
        SearchRepo searchRepo = remoteDataSource.createApiService(SearchRepo.class);
        Observable<List<Repos>> observable = searchRepo.getContributorsReposList(repoUrl);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((reposList)->{
                        List<Repos> list = new ArrayList<>();
                    for (Repos repos:
                         reposList) {
                        list.add(repos);
                    }
                    reposObservableList.addAll(list);
                });

    }
}
