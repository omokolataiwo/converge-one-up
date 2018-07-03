package com.andela.omokolataiwo.levelup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView mUsernameTextView;
    ImageView mProfileImageView;
    String mUsername, mProfileImage;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        mUsernameTextView = findViewById(R.id.tv_username);
        mProfileImageView = findViewById(R.id.iv_profile_image);
        viewProfile();
        getSupportActionBar().setTitle(mUsername);
    }

    private void viewProfile() {
        intent = this.getIntent();
        mUsername = intent.getStringExtra("USER_NAME");
        mProfileImage = intent.getStringExtra("PROFILE_IMAGE");
        mUsernameTextView.setText(mUsername);
        Picasso.get().load(mProfileImage).into(mProfileImageView);
    }

}
