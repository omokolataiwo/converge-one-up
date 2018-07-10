package com.andela.omokolataiwo.levelup.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andela.omokolataiwo.levelup.R;
import com.andela.omokolataiwo.levelup.presenter.GithubProfilePresenter;

public class MainActivity extends AppCompatActivity {
    private GithubProfilePresenter githubProfilePresenter =
            new GithubProfilePresenter(this);
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
