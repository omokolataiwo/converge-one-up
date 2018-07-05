package com.andela.omokolataiwo.levelup.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.andela.omokolataiwo.levelup.R;
import com.andela.omokolataiwo.levelup.models.GithubProfile;
import com.andela.omokolataiwo.levelup.presenter.GithubProfilePresenter;
import com.andela.omokolataiwo.levelup.service.GithubAPI;
import com.andela.omokolataiwo.levelup.service.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GithubProfilePresenter githubProfilePresenter = new GithubProfilePresenter(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        githubProfilePresenter.updateAdapter(recyclerView);
    }
}
