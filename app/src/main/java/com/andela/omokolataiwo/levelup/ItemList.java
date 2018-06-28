package com.andela.omokolataiwo.levelup;

import android.net.Uri;

public class ItemList {
    private String mUsername;
    private String mProfilePicture;

    public ItemList(String username, String picture) {
        mUsername = username;
        mProfilePicture = picture;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getProfilePicture() {
        return mProfilePicture;
    }
}
