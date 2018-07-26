package com.andela.omokolataiwo.levelup.contract;

import com.andela.omokolataiwo.levelup.models.GithubProfile;

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
         * @param status Status of the request. True it's successful, False it failed
         */
        void hideSwipe(boolean status);
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

}
