package com.andela.omokolataiwo.levelup.view;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.util.Log;

import com.andela.omokolataiwo.levelup.R;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasType;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

/**
 * Test detail activity.
 */
public class DetailActivityTest {
  /**
   * Intent username.
   */
  private static final String USERNAME = "taiwo";
  /**
   * Intent profile image.
   */
  private static final String PROFILE_IMAGE = "https://bit.ly/2LJmRQq";
  /**
   * Intent profile url.
   */
  private static final String PROFILE_URL = "https://github.com/omokolataiwo";

  /**
   * Detail Activity component.
   */
  @Rule
  public IntentsTestRule<DetailActivity> mDetailActivity =
    new IntentsTestRule<>(DetailActivity.class, true, false);

  /**
   * Setup test suite.
   *
   * @throws Exception Exception
   */
  @Before
  public void setUp() throws Exception {
    Intent intent = new Intent();
    intent.putExtra("username", USERNAME);
    intent.putExtra("profile image", PROFILE_IMAGE);
    intent.putExtra("profile url", PROFILE_URL);
    mDetailActivity.launchActivity(intent);
  }

  /**
   * Check activity display with Intent.
   */
  @Test
  public void launchActivityWithExpectedIntent() {
    onView(withId(R.id.cv_user_details))
      .check(matches(hasDescendant(allOf(withId(R.id.tv_username), withText(USERNAME)))))
      .check(matches(isDisplayed()));

    onView(withId(R.id.cv_user_details))
      .check(matches(hasDescendant(allOf(withId(R.id.tv_github_address), withText(PROFILE_URL)))))
      .check(matches(isDisplayed()));

    onView(withId(R.id.iv_profile_image))
      .check(matches(isDisplayed()));
  }

  /**
   * Check Github user URL is clickable.
   *
   * @throws Exception Exception
   */
  @Test
  public void ensureGithubLinkWorksCorrectly() throws Exception {
    onView(withId(R.id.tv_github_address)).perform(click());
    Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData(PROFILE_URL));
    intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
    intended(expectedIntent);
  }

  /**
   * Check share functionality activate options.
   *
   * @throws Exception Exception
   */
  @Test
  public void ensureShareLinkWorksCorrectly() throws Exception {
    try {
      openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
    } catch (Exception e) {
      Log.e("TAG", e.getMessage());
    }

    onView(anyOf(withText(R.string.share), withId(R.id.share_profile))).perform(click());
    intended(allOf(
      hasAction(Intent.ACTION_SEND),
      hasType("text/plain")));
  }
}
