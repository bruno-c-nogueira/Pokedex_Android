package com.example.pokedex.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pokedex.model.Pokemon;

@Database(entities = {Pokemon.class}, version = 2, exportSchema = false)
public abstract class PokemonDatabase extends RoomDatabase {

    public abstract RoomPokemonDao getRoomDao();

    public static PokemonDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, PokemonDatabase.class, "pokemon.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }

}
