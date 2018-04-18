package com.example.elijahsmith.videogamelibrary;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoGameAdapter extends RecyclerView.Adapter<VideoGameAdapter.ViewHolder> {

    private List<Game> gameList;
    private AdapterCallback adapterCallback;

    public VideoGameAdapter(List<Game> gameList, AdapterCallback adapterCallback) {
        this.gameList = gameList;
        this.adapterCallback = adapterCallback;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_game, parent, false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindGame(gameList.get(position));

        //TODO - Set up onClicks for deleting and checking out
        holder.itemView.setOnClickListener(holder.onClick(gameList.get(position)));
        holder.itemView.setOnLongClickListener();

    }

    @Override
    public int getItemCount() {

        return gameList.size();
    }
    public void updateList(List<Game> list) {
        gameList = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //TODO - Create ViewHolder Variables and methods
        @BindView(R.id.item_row_layout)
        protected RelativeLayout rowlayout;
        @BindView(R.id.item_title)
        protected TextView gameTitle;
        @BindView(R.id.item_genre)
        protected TextView genre;
        @BindView(R.id.item_date)
        protected TextView gameDate;

        public ViewHolder (View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
        public void bindGame (Game game) {

            VideoGameApplication videoGameApplication= new VideoGameApplication();
            Resources res = videoGameApplication

            gameTitle.setText(game.getGameTitle());
            genre.setText(R.string.genre_2_s, game.getGameGenre());

        }




    }

    public interface AdapterCallback {
        //TODO:Create callback methods needed


    }


}
