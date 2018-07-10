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
         * @param githubProfiles Github profiles.
         */
        void displayDeveloperList(List<GithubProfile> githubProfiles);
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
