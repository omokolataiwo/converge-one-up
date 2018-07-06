package com.andela.omokolataiwo.levelup.service;

import com.andela.omokolataiwo.levelup.models.GithubProfileResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubAPI {
    @GET("/search/users?q=language:java+location:lagos")
    Call<GithubProfileResponse> getAllProfile();
}