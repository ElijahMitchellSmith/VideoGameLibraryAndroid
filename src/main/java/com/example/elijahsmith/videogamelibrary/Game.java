package com.example.elijahsmith.videogamelibrary;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Game {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String gameTitle;
    private String gameGenre;
    private boolean isCheckedOut;
    private Date date;

    public Game(String gameTitle, String gameGenre, Date date) {
        this.gameTitle = gameTitle;
        this.gameGenre = gameGenre;
        this.date = date;
    }


    public Game() {
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {

        return id;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public Date getDate() {
        return date;
    }
}
