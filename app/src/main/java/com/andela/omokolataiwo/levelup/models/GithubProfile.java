package com.andela.omokolataiwo.levelup.models;

import com.google.gson.annotations.SerializedName;

public class GithubProfile {
    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    public GithubProfile(String login, String avatarUrl, String htmlUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}
