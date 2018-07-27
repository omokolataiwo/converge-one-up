package com.andela.omokolataiwo.levelup.util;

import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;

/**
 * EspressoIdlingResource class.
 */
public final class EspressoIdlingResource {
  /**
   * Resource scope.
   */
  private static final String RESOURCE = "GLOBAL";

  /**
   * Resource idling counter.
   */
  private static CountingIdlingResource mCountingIdlingResource
    = new CountingIdlingResource(RESOURCE);

  /**
   * private constructor.
   * prevents instantiation
   */
  private EspressoIdlingResource() {
    // cannot be instantiated
  }

  /**
   * Increment counter.
   */
  public static void increment() {
    mCountingIdlingResource.increment();
  }

  /**
   * Decrement counter.
   */
  public static void decrement() {
    mCountingIdlingResource.decrement();
  }

  /**
   * Get instance of IdlingResource.
   *
   * @return - instance of the IdlingResource
   */
  public static IdlingResource getIdlingResource() {
    return mCountingIdlingResource;
  }
}
