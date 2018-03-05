package com.example.shalini.assignment.contributorDetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shalini.assignment.R;
import com.example.shalini.assignment.data.RemoteDataSource;
import com.example.shalini.assignment.data.models.Contributor;
import com.example.shalini.assignment.databinding.ActivityContributorDetailsBinding;

import java.util.ArrayList;

import static com.example.shalini.assignment.AppConstants.EXTRA_CONTRIBUTOR;

public class ContributorDetailsActivity extends AppCompatActivity {
    private Contributor mContributor;
    private ContributorDetailsViewModel mContributorViewModel;
    private ActivityContributorDetailsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContributor = getIntent().getParcelableExtra(EXTRA_CONTRIBUTOR);

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_contributor_details);
        mContributorViewModel = new ContributorDetailsViewModel(RemoteDataSource.getInstance());

        mBinding.setContributor(mContributor);
        mBinding.setViewModel(mContributorViewModel);

        mContributorViewModel.start(mContributor);
        setRepoList();
    }

    private void setRepoList() {
        RecyclerView recyclerView = mBinding.recyclerViewReposList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ContributorRepoListAdapter adapter = new ContributorRepoListAdapter(new ArrayList<>(0));
        recyclerView.setAdapter(adapter);
    }
}
