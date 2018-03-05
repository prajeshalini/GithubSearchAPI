package com.example.shalini.assignment.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shalini Prajesh on 3/3/18.
 */

public class ReposList {
    @SerializedName("items")
    private List<Repos> reposList;

    public List<Repos> getReposList() {
        return reposList;
    }
}
