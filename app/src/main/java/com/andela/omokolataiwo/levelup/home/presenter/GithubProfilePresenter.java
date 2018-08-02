package com.andela.omokolataiwo.levelup.home.presenter;


import com.andela.omokolataiwo.levelup.contract.MainContract;
import com.andela.omokolataiwo.levelup.home.models.GithubProfile;

import java.util.List;


/**
 * Github Profile Presenter.
 */
public class GithubProfilePresenter implements MainContract.MainPresenter,
  MainContract.GetGithubProfileIntractor.OnFinishedListener {
  /**
   * View context of the presenter.
   */
  private final MainContract.MainView mView;

  /**
   * Get Github Profile Intractor.
   */
  private final MainContract.GetGithubProfileIntractor getGithubProfileIntractor;

  /**
   * GithubProfilePresenter constructor.
   *
   * @param view                      Activity of the request.
   * @param getGithubProfileIntractor the get github profile intractor
   */
  public GithubProfilePresenter(MainContract.MainView view,
                                MainContract.GetGithubProfileIntractor getGithubProfileIntractor) {
    this.mView = view;
    this.getGithubProfileIntractor = getGithubProfileIntractor;
  }


  /**
   * Fetches Github users' profile for Github API.
   */
  @Override
  public void fetchData() {
    if (!mView.getNetworkConnectionState()) {
      mView.showNotification("No Network Connection");
      mView.hideSwipe(false);
      return;
    }

    getGithubProfileIntractor.getGithubProfileArrayList(this);
  }

  @Override
  public void onFinished(List<GithubProfile> githubProfiles) {
    mView.displayDeveloperList(githubProfiles);
    mView.hideSwipe(true);
  }

  @Override
  public void onFailure(Throwable throwable) {
    mView.showNotification("Slow network connection. Please try again.");
    mView.hideSwipe(false);
  }
}
