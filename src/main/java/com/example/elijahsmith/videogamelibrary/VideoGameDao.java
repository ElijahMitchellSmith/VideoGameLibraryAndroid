package com.example.elijahsmith.videogamelibrary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface VideoGameDao {

    //Allow us to get all video games
    @Query("SELECT * FROM Game")
    List<Game> getGames();
    //Allow us to add a single game to the list
    @Insert
    void addGame(Game game);
    //Allow us to update the values of an existing game
    @Update
    void updateGame(Game game);

    //Allows us to delete a game from the library
    @Delete
    void deleteGame(Game game);

}
