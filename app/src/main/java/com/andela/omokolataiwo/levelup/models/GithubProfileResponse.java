package com.andela.omokolataiwo.levelup.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GithubProfileResponse {
    @SerializedName("items")
    private List<GithubProfile> mGithubProfiles;

    public List<GithubProfile> getGithubProfiles() {
        return mGithubProfiles;
    }
}