package com.example.shalini.assignment.RepoDetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;

import com.example.shalini.assignment.R;
import com.example.shalini.assignment.data.RemoteDataSource;
import com.example.shalini.assignment.data.models.Repos;
import com.example.shalini.assignment.databinding.ActivityRepoDetailsBinding;

import java.util.ArrayList;

import static com.example.shalini.assignment.AppConstants.EXTRA_REPO;

public class RepoDetailsActivity extends AppCompatActivity {
    Repos mRepos;
    private static final String TAG = "RepoDetailsActivity";
    private ActivityRepoDetailsBinding activityRepoDetailsBinding;
    private RemoteDataSource mRemoteDataSource;
    private RepoDetailViewModel mRepoDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRemoteDataSource = RemoteDataSource.getInstance();
        mRepos = getIntent().getParcelableExtra(EXTRA_REPO);

        activityRepoDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_repo_details);
        mRepoDetailsViewModel = new RepoDetailViewModel(mRemoteDataSource,this);

        activityRepoDetailsBinding.setRepo(mRepos);
        activityRepoDetailsBinding.setViewModel(mRepoDetailsViewModel);
        mRepoDetailsViewModel.start(mRepos);
        setContributorsList();
//        activityRepoDetailsBinding.textViewUrl.setLinksClickable(true);
//        activityRepoDetailsBinding.textViewUrl.setMovementMethod(LinkMovementMethod.getInstance());
//        activityRepoDetailsBinding.textViewUrl.setText(Html.fromHtml("<a href="+mRepos.getHtmlUrl()+"></a>"));
       Linkify.addLinks(activityRepoDetailsBinding.textViewUrl, Linkify.WEB_URLS);
    }

    private void setContributorsList() {
        RecyclerView recyclerView = activityRepoDetailsBinding.recyclerviewContributors;
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        ContributorsAdapter contributorsAdapter = new ContributorsAdapter(new ArrayList<>(0));
        recyclerView.setAdapter(contributorsAdapter);
    }
}
