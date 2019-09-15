package com.example.pokedex.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pokedex.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface RoomPokemonDao {

    @Insert
    void salvaPokemon(ArrayList<Pokemon> pokemons);

    @Query("SELECT * FROM pokemon")
    List<Pokemon> buscaPokemon();

    @Delete
    void apagaPokemon(ArrayList<Pokemon> pokemons);

    @Update
    void editaPokemon(ArrayList<Pokemon> pokemons);
}
