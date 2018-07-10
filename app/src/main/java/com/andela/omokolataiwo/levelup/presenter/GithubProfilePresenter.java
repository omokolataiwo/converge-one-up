package com.andela.omokolataiwo.levelup.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.andela.omokolataiwo.levelup.ListAdapter;
import com.andela.omokolataiwo.levelup.models.GithubProfile;
import com.andela.omokolataiwo.levelup.models.GithubProfileResponse;
import com.andela.omokolataiwo.levelup.service.RetrofitClientInstance;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubProfilePresenter {
    private Context context;

    public GithubProfilePresenter(Context context) {
        this.context = context;
    }

    public void updateAdapter(final RecyclerView recyclerView) {
        RetrofitClientInstance.getRetrofitClientInstance()
                .getAllProfile()
                .enqueue(new Callback<GithubProfileResponse>() {
            @Override
            public void onResponse(@NonNull Call<GithubProfileResponse> call,
                                   @NonNull Response<GithubProfileResponse> response) {
                List<GithubProfile> githubProfiles = response.body().getGithubProfiles();

                if (githubProfiles != null)
                    recyclerView.setAdapter(new ListAdapter(githubProfiles, context));
            }

            @Override
            public void onFailure(@NonNull Call<GithubProfileResponse> call, Throwable t) {

            }
        });
    }
}
