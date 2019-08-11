package com.example.pokedex.controlers;
import java.util.ArrayList;

import com.example.pokedex.model.Pokemons;
import com.google.gson.annotations.SerializedName;


public class ResponsePokemon {
    @SerializedName("results")
    private ArrayList<Pokemons> results;

    public ResponsePokemon(ArrayList<Pokemons> results) {
        this.results = results;
    }


    public ArrayList<Pokemons> getPokemons() {
        return results;
    }

}
