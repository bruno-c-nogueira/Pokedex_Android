package com.example.pokedex.service;

import com.example.pokedex.controlers.ResponsePokemon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("pokemon")
    Call<ResponsePokemon> getPokemons();
}
