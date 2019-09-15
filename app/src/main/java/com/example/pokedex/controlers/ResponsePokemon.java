package com.example.pokedex.controlers;
import java.util.ArrayList;

import com.example.pokedex.model.Pokemon;
import com.google.gson.annotations.SerializedName;


public class ResponsePokemon {
    @SerializedName("results")
    private ArrayList<Pokemon> results;

    public ResponsePokemon(ArrayList<Pokemon> results) {
        this.results = results;
    }


    public ArrayList<Pokemon> getPokemons() {
        return results;
    }

}
