package com.andela.omokolataiwo.levelup.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.andela.omokolataiwo.levelup.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView mUsernameTextView;
    TextView mUserUrlTextView;
    ImageView mProfileImageView;
    String mUsername, mProfileImage, mUserUrl;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        mUsernameTextView = findViewById(R.id.tv_username);
        mProfileImageView = findViewById(R.id.iv_profile_image);
        mUserUrlTextView = findViewById(R.id.tv_github_address);
        viewProfile();
        getSupportActionBar().setTitle(mUsername);
    }

    private void viewProfile() {
        intent = this.getIntent();
        final String USERNAME = "username";
        final String PROFILE_IMAGE = "profile image";
        final String PROFILE_URL = "profile url";

        mUsername = intent.getStringExtra(USERNAME);
        mProfileImage = intent.getStringExtra(PROFILE_IMAGE);
        mUserUrl = intent.getStringExtra(PROFILE_URL);

        mUsernameTextView.setText(mUsername);
        mUserUrlTextView.setText(mUserUrl);
        Picasso.get().load(mProfileImage).into(mProfileImageView);
    }

}
