package com.andela.omokolataiwo.levelup.service;

import retrofit2.Call;
import retrofit2.http.GET;

import com.andela.omokolataiwo.levelup.models.GithubProfileResponse;

public interface GithubAPI {
    @GET("/search/users?q=language:java+location:lagos")
    Call<GithubProfileResponse> getAllProfile();
}
