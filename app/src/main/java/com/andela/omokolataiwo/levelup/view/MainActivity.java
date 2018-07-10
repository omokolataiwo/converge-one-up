package com.andela.omokolataiwo.levelup.view;

import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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
     * github profile parcel.
     */
    private List<GithubProfile> githubProfilesParcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubProfilePresenter githubProfilePresenter = new GithubProfilePresenter(this,
                (CoordinatorLayout) findViewById(R.id.coordinatorLayout));

        recyclerView = findViewById(R.id.recycler_view);

        if (savedInstanceState != null) {
            githubProfilesParcel = savedInstanceState
                    .getParcelableArrayList(PARCEL_KEY);
            displayDeveloperList(githubProfilesParcel);
        } else {
            githubProfilePresenter.fetchData();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(
                PARCEL_KEY, (ArrayList<? extends Parcelable>) githubProfilesParcel);
    }

    @Override
    public void displayDeveloperList(List<GithubProfile> githubProfiles) {
        githubProfilesParcel = githubProfiles;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new ListAdapter(githubProfiles));
    }
}
