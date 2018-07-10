package com.andela.omokolataiwo.levelup.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * A developer github profile.
 */
public class GithubProfile implements Parcelable {
    /**
     * Developer's username.
     */
    @SerializedName("login")
    private final String login;

    /**
     * Developer Picture URL.
     */
    @SerializedName("avatar_url")
    private final String avatarUrl;

    /**
     * Developer Github URL.
     */
    @SerializedName("html_url")
    private final String htmlUrl;

    /**
     * GithubProfile constructor.
     *
     * @param login     Developer username
     * @param avatarUrl Developer picture url
     * @param htmlUrl   Developer github address
     */
    public GithubProfile(String login, String avatarUrl, String htmlUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
    }

    /**
     * Gets the profile image URL.
     * @return String url
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * Gets Github username.
     * @return String username
     */
    public String getLogin() {
        return login;
    }

    /**
     * Gets the user's url address.
     * @return String Github URL
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Parcelable constructor.
     * @param in Parcelable storage
     */
    protected GithubProfile(Parcel in) {
        login = in.readString();
        avatarUrl = in.readString();
        htmlUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(avatarUrl);
        dest.writeString(htmlUrl);
    }

    /**
     * Parcelable Creator Class.
     */
    public static final Creator<GithubProfile> CREATOR = new Creator<GithubProfile>() {
        @Override
        public GithubProfile createFromParcel(Parcel in) {
            return new GithubProfile(in);
        }

        @Override
        public GithubProfile[] newArray(int size) {
            return new GithubProfile[size];
        }
    };
}
