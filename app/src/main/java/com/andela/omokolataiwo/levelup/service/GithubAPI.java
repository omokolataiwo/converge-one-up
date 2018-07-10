package com.andela.omokolataiwo.levelup.service;

import retrofit2.Call;
import retrofit2.http.GET;

import com.andela.omokolataiwo.levelup.models.GithubProfileResponse;

/**
 * Github request API.
 */
public interface GithubAPI {
    /**
     * Fetch developer's profile from github.
     *
     * @return GithubProfileResponse
     */
    @GET("/search/users?q=language:java+location:lagos")
    Call<GithubProfileResponse> getAllProfile();
}
