package com.andela.omokolataiwo.levelup.presenter;

import android.support.annotation.NonNull;

import com.andela.omokolataiwo.levelup.contract.MainContract;
import com.andela.omokolataiwo.levelup.models.GithubProfile;
import com.andela.omokolataiwo.levelup.models.GithubProfileResponse;
import com.andela.omokolataiwo.levelup.service.RetrofitClientInstance;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Github Profile Presenter.
 */
public class GithubProfilePresenter implements MainContract.MainPresenter {
    /**
     * View context of the presenter.
     */
    private final MainContract.MainView mView;

    /**
     * GithubProfilePresenter constructor.
     *
     * @param view Activity of the request.
     */
    public GithubProfilePresenter(MainContract.MainView view) {
        this.mView = view;
    }


    @Override
    /**
     * Fetches Github users' profile for Github API
     */
    public void fetchData() {
        RetrofitClientInstance
                .getRetrofitClientInstance()
                .getAllProfile()
                .enqueue(new Callback<GithubProfileResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<GithubProfileResponse> call,
                                           @NonNull Response<GithubProfileResponse> response) {
                        List<GithubProfile> githubProfiles = response
                                .body().getGithubProfiles();
                        mView.displayDeveloperList(githubProfiles);
                    }

                    @Override
                    public void onFailure(@NonNull Call<GithubProfileResponse> call, Throwable t) {
                        // Implement when request fails.
                    }
                });
    }
}
