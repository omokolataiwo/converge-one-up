package com.andela.omokolataiwo.levelup.home.presenter;

import android.support.annotation.NonNull;

import com.andela.omokolataiwo.levelup.contract.MainContract;
import com.andela.omokolataiwo.levelup.home.models.GithubProfile;
import com.andela.omokolataiwo.levelup.home.models.GithubProfileResponse;
import com.andela.omokolataiwo.levelup.service.RetrofitClient;

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
    if (!mView.getNetworkConnectionState()) {
      mView.showNotification("No Network Connection");
      mView.hideSwipe(false);
      return;
    }

    RetrofitClient.getInstance().getAllProfile()
      .enqueue(new Callback<GithubProfileResponse>() {
        @Override
        public void onResponse(@NonNull Call<GithubProfileResponse> call,
                               @NonNull Response<GithubProfileResponse> response) {
          List<GithubProfile> githubProfiles = response.body().getGithubProfiles();
          mView.displayDeveloperList(githubProfiles);
          mView.hideSwipe(true);
        }

        @Override
        public void onFailure(@NonNull Call<GithubProfileResponse> call, Throwable t) {
          mView.showNotification("Slow network connection. Please try again.");
          mView.hideSwipe(false);
        }
      });
  }

}