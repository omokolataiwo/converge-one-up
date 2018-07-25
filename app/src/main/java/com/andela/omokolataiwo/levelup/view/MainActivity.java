package com.andela.omokolataiwo.levelup.view;

import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.andela.omokolataiwo.levelup.ListAdapter;
import com.andela.omokolataiwo.levelup.R;
import com.andela.omokolataiwo.levelup.contract.MainContract;
import com.andela.omokolataiwo.levelup.models.GithubProfile;
import com.andela.omokolataiwo.levelup.presenter.GithubProfilePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Activity.
 */
public class MainActivity extends AppCompatActivity implements MainContract.MainView {
    /**
     * Recycler view instance.
     */
    private RecyclerView recyclerView;
    /**
     * Parcel key.
     */
    private static final String PARCEL_KEY = "keytopackage";
    /**
     * Github profile parcel.
     */
    private List<GithubProfile> githubProfilesParcel;

    /**
     * Swipe refresh layout.
     */
    private SwipeRefreshLayout swipeRefreshLayout;

    /**
     * Github profile presenter.
     */
    private GithubProfilePresenter githubProfilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        swipeRefreshLayout = findViewById(R.id.main_activity_swipe_refresh);
        githubProfilePresenter = new GithubProfilePresenter(this);

        setupSwipeRefresh();

        if (savedInstanceState != null) {
            githubProfilesParcel = savedInstanceState.getParcelableArrayList(PARCEL_KEY);
            displayDeveloperList(githubProfilesParcel);
        } else {
            githubProfilePresenter.fetchData();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(PARCEL_KEY,
                (ArrayList<? extends Parcelable>) githubProfilesParcel);
    }

    @Override
    public void displayDeveloperList(List<GithubProfile> githubProfiles) {
        githubProfilesParcel = githubProfiles;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new ListAdapter(githubProfiles));
    }

    @Override
    public void showNotification(String message) {
        Snackbar.make((CoordinatorLayout) findViewById(R.id.coordinatorLayout),
                message,
                Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void hideSwipe(boolean status) {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
            if (status) {
                Toast.makeText(this,
                        "Github Developers' list refreshed.",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    /**
     * Set swipe properties.
     */
    private void setupSwipeRefresh() {
        swipeRefreshLayout.setColorSchemeResources(
                R.color.refresh_red,
                R.color.refresh_blue,
                R.color.refresh_green);
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                githubProfilePresenter.fetchData();
            }
        });
    }
}
