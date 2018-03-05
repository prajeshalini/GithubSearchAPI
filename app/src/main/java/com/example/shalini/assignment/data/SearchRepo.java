package com.example.shalini.assignment.data;

import com.example.shalini.assignment.data.models.Contributor;
import com.example.shalini.assignment.data.models.Repos;
import com.example.shalini.assignment.data.models.ReposList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Shalini Prajesh on 3/3/18.
 */

public interface SearchRepo {
    @GET("/search/repositories")
    Call<ReposList> getRepoList(@Query("q")String searchText,
                                @Query("sort")String sortParam,
                                @Query("order")String sortingOrder,
                                @Query("per_page")String perPageCount);

    @GET("/search/repositories")
    Observable<ReposList> getRepositoryList(@Query("q")String searchText,
                                            @Query("sort")String sortParam,
                                            @Query("order")String sortingOrder,
                                            @Query("per_page")String perPageCount);

    @GET
    Observable<List<Contributor>> getContributorList(@Url String url);

    @GET
    Observable<List<Repos>> getContributorsReposList(@Url String url);
}
