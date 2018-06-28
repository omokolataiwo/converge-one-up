package com.andela.omokolataiwo.levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private static List<ItemList> githubUserProfile = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListAdapter(githubUserProfile, this);
        recyclerView.setAdapter(adapter);
    }
    static {
        githubUserProfile.add(new ItemList("@Leumas", "https://avatars2.githubusercontent.com/u/8110201?v=4"));

        githubUserProfile.add(new ItemList("@Hero", "https://avatars1.githubusercontent.com/u/4929406?v=4"));

        githubUserProfile.add(new ItemList("@Rio", "https://avatars0.githubusercontent.com/u/6113672?v=4"));

        githubUserProfile.add(new ItemList("@Invincible", "https://avatars1.githubusercontent.com/u/6963510?v=4"));
        githubUserProfile.add(new ItemList("@Chukky", "https://avatars3.githubusercontent.com/u/13552664?v=4"));

        githubUserProfile.add(new ItemList("@Sparrow", "https://avatars3.githubusercontent.com/u/678974?v=4"));

        githubUserProfile.add(new ItemList("@Bravo", "https://avatars3.githubusercontent.com/u/16584163?v=4"));

        githubUserProfile.add(new ItemList("@Parker", "https://avatars1.githubusercontent.com/u/5605785?v=4"));

        githubUserProfile.add(new ItemList("@Flash", "https://avatars1.githubusercontent.com/u/19608533?v=4"));

        githubUserProfile.add(new ItemList("@Huck", "https://avatars2.githubusercontent.com/u/5692718?v=4"));

        githubUserProfile.add(new ItemList("@Blaze", "https://avatars2.githubusercontent.com/u/15170090?v=4"));

        githubUserProfile.add(new ItemList("@Warlock", "https://avatars2.githubusercontent.com/u/5986979?v=4"));
    }
}
