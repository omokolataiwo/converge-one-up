package com.andela.omokolataiwo.levelup.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * The type Connectivity.
 */
public final class Connectivity {

  /**
   * Connectivity constructor.
   */
  private Connectivity() {
    // left blank intentionally.
  }

  /**
   * Is connected boolean.
   *
   * @param context the context
   * @return connected or not
   */
  public static boolean isConnected(Context context) {
    ConnectivityManager connectivityManager =
      (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    assert connectivityManager != null;
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    return networkInfo != null && networkInfo.isConnected();
  }
}
