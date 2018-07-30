package com.andela.omokolataiwo.levelup;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.andela.omokolataiwo.levelup.util.EspressoIdlingResource;
import com.andela.omokolataiwo.levelup.userDetail.view.DetailActivity;
import com.andela.omokolataiwo.levelup.home.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

/**
 * import Android JUnit class.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
  /**
   * Recycler view element's position.
   */
  private static final int SCROLL_POSITION = 12;

  /**
   * component under test.
   */
  @Rule
  public IntentsTestRule<MainActivity> mActivityRule =
    new IntentsTestRule<MainActivity>(MainActivity.class);

  /**
   * Setup test suite.
   *
   * @throws Exception Exception
   */
  @Before
  public void setUp() throws Exception {
    IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
  }

  /**
   * Teardown resources.
   *
   * @throws Exception Exception
   */
  @After
  public void tearDown() throws Exception {
    IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
  }

  /**
   * Test recycler view display.
   */
  @Test
  public void recyclerViewDisplayed() {
    onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
  }

  /**
   * Test recycler view at a position.
   */
  @Test
  public void recyclerViewIsScrollable() {
    onView(withId(R.id.recycler_view))
      .perform(RecyclerViewActions.scrollToPosition(SCROLL_POSITION))
      .perform(RecyclerViewActions.actionOnItemAtPosition(SCROLL_POSITION, click()));

    intended(allOf(
      hasComponent(DetailActivity.class.getName()),
      hasExtraWithKey("username"),
      hasExtraWithKey("profile image"),
      hasExtraWithKey("profile url")
      )
    );
  }
}
