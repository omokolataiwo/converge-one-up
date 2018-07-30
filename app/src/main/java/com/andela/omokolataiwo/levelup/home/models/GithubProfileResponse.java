package com.andela.omokolataiwo.levelup.home.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Gets response from the API.
 */
public class GithubProfileResponse {
    /**
     * items from the JSON.
     */
    @SerializedName("items")
    private List<GithubProfile> mGithubProfiles;

    /**
     * Return item.
     * @return item
     */
    public List<GithubProfile> getGithubProfiles() {
        return mGithubProfiles;
    }
}
