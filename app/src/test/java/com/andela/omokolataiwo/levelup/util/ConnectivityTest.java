package com.andela.omokolataiwo.levelup.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

/**
 * The type Connectivity test.
 */
public class ConnectivityTest {
  /**
   * The Context.
   */
  @Mock
  Context context;

  /**
   * The Connectivity manager.
   */
  @Mock
  ConnectivityManager connectivityManager;

  /**
   * The Network info.
   */
  @Mock
  NetworkInfo networkInfo;

  /**
   * The Mockito rule.
   */
  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  /**
   * Returns true when network info is true.
   *
   * @throws Exception the exception
   */
  @Test
  public void returnsTrueWhenNetworkInfoIsTrue() throws Exception {
    Mockito.when(context.getSystemService(Context.CONNECTIVITY_SERVICE))
      .thenReturn(connectivityManager);
    Mockito.when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);
    Mockito.when(networkInfo.isConnected()).thenReturn(true);

    Assert.assertTrue(networkInfo.isConnected());
    Mockito.verify(networkInfo, Mockito.times(1)).isConnected();
  }

  /**
   * Returns false when network info is false.
   *
   * @throws Exception the exception
   */
  @Test
  public void returnsFalseWhenNetworkInfoIsFalse() throws Exception {
    Mockito.when(context.getSystemService(Context.CONNECTIVITY_SERVICE))
      .thenReturn(connectivityManager);
    Mockito.when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);
    Mockito.when(networkInfo.isConnected()).thenReturn(false);

    Assert.assertFalse(networkInfo.isConnected());
    Mockito.verify(networkInfo, Mockito.times(1)).isConnected();
  }

  /**
   * Returns false when network info is null.
   *
   * @throws Exception the exception
   */
  @Test
  public void returnsFalseWhenNetworkInfoIsNull() throws Exception {
    Mockito.when(context.getSystemService(Context.CONNECTIVITY_SERVICE))
      .thenReturn(connectivityManager);
    Mockito.when(connectivityManager.getActiveNetworkInfo()).thenReturn(null);

    Assert.assertNull(connectivityManager.getActiveNetworkInfo());
    Assert.assertFalse(Connectivity.isConnected(context));
  }
}
