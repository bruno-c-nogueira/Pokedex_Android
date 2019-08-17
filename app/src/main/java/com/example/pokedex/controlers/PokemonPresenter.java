package com.example.pokedex.controlers;

import android.content.Context;

public class PokemonPresenter implements PokemonModel.Presenter{
    Context context;
    RepositoryPokedex repository;
    PokemonModel.View view;


    public PokemonPresenter(Context context, PokemonModel.View view) {
        this.context = context;
        this.view = view;

        //repository
        repository = new RepositoryPokedex(context, this);

    }

    @Override
    public void requestLoadPokemonList() {
        repository.resquestPokemon();
    }

    @Override
    public void onSucessRequestPokemon(ResponsePokemon responsePokemon) {
        if(responsePokemon != null && responsePokemon.getPokemons() != null){
            view.onSucessRequestPokemon(responsePokemon);
        }
    }

    @Override
    public void onFailureRequestPokemon(Throwable t) {
        view.onFailureRequestPokemon(t);
    }


}
