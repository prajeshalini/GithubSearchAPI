package com.example.shalini.assignment;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;

import com.example.shalini.assignment.data.RemoteDataSource;
import com.example.shalini.assignment.data.models.Repos;
import com.example.shalini.assignment.data.SearchRepo;
import com.example.shalini.assignment.data.models.ReposList;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Shalini Prajesh on 3/3/18.
 */

public class ReposViewModel extends BaseObservable implements  ApiResult{
    private static final String TAG = "ReposViewModel";
    public ObservableList<Repos> mRepoList = new ObservableArrayList<>();
    public ObservableField<String> searchQuery = new ObservableField<>();
    private RemoteDataSource mRemoteDataSource;
    private Context mContext;
    private RepoNavigator mRepoNavigator;

    public ReposViewModel(RemoteDataSource mRemoteDataSource, Context mContext) {
        this.mRemoteDataSource = mRemoteDataSource;
        this.mContext = mContext;
    }

    public void search(RepoNavigator repoNavigator,String query){
        mRepoNavigator = repoNavigator;
        loadRepos(query);
    }


    private void loadRepos(String query) {
        SearchRepo searchRepo = mRemoteDataSource.createApiService(SearchRepo.class);
        Observable<ReposList> observable = searchRepo.getRepositoryList(query,"watchers","desc",String.valueOf(10));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((reposList)->{
                    updateListData(reposList);
                });
    }

    private void updateListData(ReposList reposList) {
        List<Repos> repoList = new ArrayList<>();
        for (Repos repos :
                reposList.getReposList()) {
            Log.e(TAG, "onCreate: REPO NAME>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+repos.getWatchersCount() +">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                    ""+ repos.getOwner().getAvatarUrl());
            repoList.add(repos);
            Log.e(TAG, "search: >>>>>>>>>>>>>>>>>>>>"+mRepoList.size());
        }
        if (mRepoList.size()>0){
            mRepoList.clear();
        }
        mRepoList.addAll(repoList);
}

    @Override
    public void onSuccess(List<Repos> list) {
        Log.e(TAG, "onSuccess: " + list.size());
     //   mRepoList.addAll(list);
    }

    @Override
    public void failure() {

    }
}
