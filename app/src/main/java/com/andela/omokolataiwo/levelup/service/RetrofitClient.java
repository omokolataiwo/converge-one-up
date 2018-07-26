package com.andela.omokolataiwo.levelup.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit client instance.
 */
public final class RetrofitClient {
    /**
     * Base URL.
     */
    private static final String BASE_URL = "https://api.github.com/";

    /**
     * Retrofit Github API.
     */
    private static GithubAPI instance = new Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubAPI.class);

    /**
     * private RetrofitClientInstance constructor as singleton.
     */
    private RetrofitClient() {
        // left blank intentionally. Singleton design pattern.
    }

    /**
     * Constructor.
     *
     * @return GithubAPI Github API.
     */

    public static GithubAPI getInstance() {
        return instance;
    }
}
