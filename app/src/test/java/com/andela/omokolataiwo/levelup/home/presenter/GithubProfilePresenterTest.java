package com.andela.omokolataiwo.levelup.home.presenter;

import com.andela.omokolataiwo.levelup.contract.MainContract;
import com.andela.omokolataiwo.levelup.home.models.GithubProfile;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The type Github profile presenter test.
 */
public class GithubProfilePresenterTest {
  /**
   * The View mock.
   */
  @Mock
  MainContract.MainView viewMock;
  /**
   * The Intractor mock.
   */
  @Mock
  MainContract.GetGithubProfileIntractor intractorMock;


  /**
   * Onfinished listener callback.
   */
  @Captor
  private ArgumentCaptor<MainContract.GetGithubProfileIntractor.OnFinishedListener>
    mCallbackArgumentCaptor;

  /**
   * The Presenter.
   */
  MainContract.MainPresenter presenter;

  /**
   * The Rule.
   */
  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    presenter = new GithubProfilePresenter(viewMock, intractorMock);
  }

  /**
   * Show network notification error when network state is false.
   */
  @Test
  public void showNetworkNotificationErrorWhenNetworkStateIsFalse() {
    Mockito.when(viewMock.getNetworkConnectionState()).thenReturn(false);
    presenter.fetchData();

    Mockito.verify(viewMock).getNetworkConnectionState();
    Mockito.verify(viewMock).showNotification("No Network Connection");
    Mockito.verify(viewMock).hideSwipe(false);
  }

  /**
   * Gets github profile array list when network connection is true.
   */
  @Test
  public void getGithubProfileArrayListWhenNetworkConnectionIsTrue() {
    Mockito.when(viewMock.getNetworkConnectionState()).thenReturn(true);
    presenter.fetchData();
    Mockito.verify(viewMock).getNetworkConnectionState();
    Mockito.verify(intractorMock).getGithubProfileArrayList(mCallbackArgumentCaptor.capture());
    final List<GithubProfile> githubProfile = new ArrayList<>();
    mCallbackArgumentCaptor.getValue().onFinished(githubProfile);
    Mockito.verify(viewMock).displayDeveloperList(githubProfile);
    Mockito.verify(viewMock).hideSwipe(true);
  }

  /**
   * Gets error response when connection is true.
   */
  @Test
  public void getErrorResponseWhenConnectionIsTrue() {
    Mockito.when(viewMock.getNetworkConnectionState()).thenReturn(true);
    presenter.fetchData();
    Mockito.verify(viewMock).getNetworkConnectionState();
    Mockito.verify(intractorMock).getGithubProfileArrayList(mCallbackArgumentCaptor.capture());

    mCallbackArgumentCaptor.getValue().onFailure(new Throwable());
    Mockito.verify(viewMock).showNotification("Slow network connection. Please try again.");
    Mockito.verify(viewMock).hideSwipe(false);
  }
}
