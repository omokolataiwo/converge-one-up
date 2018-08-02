package com.andela.omokolataiwo.levelup.contract;

import com.andela.omokolataiwo.levelup.home.models.GithubProfile;

import java.util.List;

/**
 * Main Contract.
 */
public interface MainContract {
  /**
   * MainView Contract.
   */
  interface MainView {
    /**
     * Display developer list.
     *
     * @param githubProfiles Github profiles.
     */
    void displayDeveloperList(List<GithubProfile> githubProfiles);

    /**
     * Display notification to the user.
     *
     * @param message Message to be displayed
     */
    void showNotification(String message);

    /**
     * Hide swipe when done.
     *
     * @param status Status of the request. True it's successful, False it failed
     */
    void hideSwipe(boolean status);

    /**
     * Gets network connection state.
     *
     * @return the network connection state
     */
    boolean getNetworkConnectionState();
  }

  /**
   * MainPresenter Contract.
   */
  interface MainPresenter {
    /**
     * Fetch data from endpoint.
     */
    void fetchData();
  }

  /**
   * The interface Get Profile Intractor.
   */
  interface GetGithubProfileIntractor {
    /**
     * Gets github profile array list.
     *
     * @param listener the listener
     */
    void getGithubProfileArrayList(OnFinishedListener listener);

    /**
     * The interface on finished listener.
     */
    interface OnFinishedListener {
      /**
       * On finished.
       *
       * @param githubProfiles the github profiles
       */
      void onFinished(List<GithubProfile> githubProfiles);

      /**
       * On failure.
       *
       * @param throwable the throwable error
       */
      void onFailure(Throwable throwable);
    }
  }

}
