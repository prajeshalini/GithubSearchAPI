package com.example.shalini.assignment;

import com.example.shalini.assignment.data.models.Repos;

import java.util.List;

/**
 * Created by Shalini Prajesh on 4/3/18.
 */

public interface ApiResult {

    void onSuccess(List<Repos> list);

    void failure();
}
