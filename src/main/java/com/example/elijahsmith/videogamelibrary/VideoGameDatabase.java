package com.example.elijahsmith.videogamelibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

@Database(version = 1, entities = Game.class)
@TypeConverters(DateConverter.class)

public abstract class VideoGameDatabase extends RoomDatabase {

    public abstract VideoGameDao videoGameDao();



}
