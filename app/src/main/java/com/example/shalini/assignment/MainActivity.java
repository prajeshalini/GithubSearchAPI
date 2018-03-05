package com.example.shalini.assignment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shalini.assignment.data.RemoteDataSource;
import com.example.shalini.assignment.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements RepoNavigator,SearchView.OnQueryTextListener {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding mActivityBinding;
    private ReposViewModel mReposViewModel;
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mReposViewModel = new ReposViewModel(RemoteDataSource.getInstance(),this);
        mActivityBinding.setReposViewModel(mReposViewModel);
        setReposList();
        mReposViewModel.search(this,"android");

       // mSearchView.setOnQueryTextListener(this);
    }

    private void setReposList() {
        mRecyclerView = mActivityBinding.recyclerViewList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        RepoListAdapter repoListAdapter = new RepoListAdapter(new ArrayList<>(0));
        mRecyclerView.setAdapter(repoListAdapter);
    }

    @Override
    public void navigateToRepoDetails() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        mSearchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mReposViewModel.search(this,query);
        mSearchView.setActivated(false);
        mSearchView.onActionViewCollapsed();
        mSearchView.setIconified(true);
        mSearchView.clearFocus();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
