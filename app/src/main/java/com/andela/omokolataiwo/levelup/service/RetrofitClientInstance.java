package com.andela.omokolataiwo.levelup.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit client instance.
 */
public final class RetrofitClientInstance {
    /**
     * retrofit.
     */
    /**
     * Base URL.
     */
    private static final String BASE_URL = "https://api.github.com/";

    /**
     *
     */
    private RetrofitClientInstance() {
        //
    }

    /**
     * Constructor.
     *
     * @return GithubAPI Github API.
     */

    public static GithubAPI getRetrofitClientInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubAPI.class);
    }
}
