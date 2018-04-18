package com.example.elijahsmith.videogamelibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddGameFragment extends Fragment {
    @BindView(R.id.game_name_edit)
    private EditText gameTitle;
    @BindView(R.id.genre_edit)
    private EditText gameGenre;
    private VideoGameDatabase videoGameDatabase;


    private ActivityCallback activityCallback;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_game,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static AddGameFragment newInstance() {

        Bundle args = new Bundle();

        AddGameFragment fragment = new AddGameFragment();
        fragment.setArguments(args);
        return fragment;

    }
    @Override
    public void OnStart() {
        super.onStart();
        videoGameDatabase = ((VideoGameApplication) getActivity().getApplicationContext()).getDatabase();
    }
    @OnClick(R.id.add_game_button)
    protected void addButtonClicked() {
        //TODO - Add check to make sure both fields have text, Get title and genre from edittext,create new video game object with this information, send to database to be saved, Toast that game has been saved.
        if (gameTitle.getText().toString().isEmpty() || gameGenre.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "All Fields Are Required", Toast.LENGTH_LONG).show();
        } else {
            String gameName = gameTitle.getText().toString();
            String genre = gameGenre.getText().toString();
            addGameToDatabase(gameName, genre);
            Toast.makeText(getActivity(), "Game Added!", Toast.LENGTH_LONG).show();

        }
    }
    private void addGameToDatabase(final String gameName, final String genre) {
            Game game = new Game(gameName,genre,new Date());
            videoGameDatabase.videoGameDao().addGame(game);
            activityCallback.addClicked();




    }
        public void attachParent(ActivityCallback activityCallback) {
        this.activityCallback = activityCallback;

    }
    public interface ActivityCallback {

        void addClicked();

    }

    }
}
