package com.andela.omokolataiwo.levelup.home.models;

import android.support.annotation.NonNull;

import com.andela.omokolataiwo.levelup.contract.MainContract;
import com.andela.omokolataiwo.levelup.service.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The type Get github profile intractor.
 */
public class GetGithubProfileIntractor implements MainContract.GetGithubProfileIntractor {

  /**
   * Constructor.
   *
   * @param listener the listener
   */
  @Override
  public void getGithubProfileArrayList(final OnFinishedListener listener) {
    RetrofitClient.getInstance().getAllProfile()
      .enqueue(new Callback<GithubProfileResponse>() {
        @Override
        public void onResponse(@NonNull Call<GithubProfileResponse> call,
                               @NonNull Response<GithubProfileResponse> response) {
          listener.onFinished(response.body().getGithubProfiles());
        }

        @Override
        public void onFailure(@NonNull Call<GithubProfileResponse> call, Throwable t) {
          listener.onFailure(t);
        }
      });
  }
}
