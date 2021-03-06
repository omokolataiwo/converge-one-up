package com.andela.omokolataiwo.levelup.userDetail.view;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.omokolataiwo.levelup.R;
import com.squareup.picasso.Picasso;

/**
 * Detail activity that display detailed github profile.
 */
public class DetailActivity extends AppCompatActivity {
  /**
   * user's account name text view.
   */
  TextView mUsernameTextView;
  /**
   * user's url path text view.
   */
  TextView mUserUrlTextView;
  /**
   * user's image view.
   */
  ImageView mProfileImageView;
  /**
   * username, profile image and url.
   */
  String mUsername, mProfileImage, mUserUrl;
  /**
   * Intent to get data from the parent activity.
   */
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

  /**
   * Display user's details from intent.
   */
  private void viewProfile() {
    intent = this.getIntent();

    mUsername = intent.getStringExtra("username");
    mProfileImage = intent.getStringExtra("profile image");
    mUserUrl = intent.getStringExtra("profile url");

    mUsernameTextView.setText(mUsername);
    mUserUrlTextView.setText(mUserUrl);
    Picasso.get().load(mProfileImage).into(mProfileImageView);
  }

  /**
   * @return the IntentBuilder
   */
  private Intent createShareIntent() {
    StringBuilder shareMessage = new StringBuilder();
    shareMessage.append(getResources().getString(R.string.message))
      .append(mUsername).append(", ").append(mUserUrl);

    return ShareCompat.IntentBuilder.from(this)
      .setType("text/plain")
      .setText(shareMessage)
      .getIntent();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.share_profile, menu);
    MenuItem menuItem = menu.findItem(R.id.share_profile);
    menuItem.setIntent(createShareIntent());
    return true;
  }
}
