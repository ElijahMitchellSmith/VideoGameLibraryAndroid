package com.example.elijahsmith.videogamelibrary;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements VideoGameAdapter.AdapterCallback, AddGameFragment.ActivityCallback{
    @BindView(R.id.games_recycler_view)
    private RecyclerView gameRecyclerView;
    @BindView(R.id.frame_layout)
    private AddGameFragment addGameFragment;
    
    private VideoGameDatabase videoGameDatabase;
    private VideoGameAdapter videoGameAdapter;
    private List<Game> gameList;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        
        videoGameDatabase = ((VideoGameApplication) getApplicationContext()).getDatabase();
        
        setUpRecyclerView();
        
        
    }

    private void setUpRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        videoGameAdapter = new VideoGameAdapter(videoGameDatabase.videoGameDao().getGames(), this);
        gameRecyclerView.setLayoutManager(linearLayoutManager);
        gameRecyclerView.setAdapter(videoGameAdapter);
        videoGameAdapter.notifyDataSetChanged();


    }

    @OnClick (R.id.add_game_button)
    protected void addGameButtonClicked() {
        AddGameFragment addGameFragment = AddGameFragment.newInstance();
        addGameFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,addGameFragment).commit();
    }


    @Override
    public void addClicked() {
        getSupportFragmentManager().beginTransaction().remove(addGameFragment).commit();
        videoGameAdapter.updateList(videoGameDatabase.videoGameDao().getGames());


    }
}
