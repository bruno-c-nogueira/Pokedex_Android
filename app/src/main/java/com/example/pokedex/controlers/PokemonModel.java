package com.example.pokedex.controlers;

public interface PokemonModel {
    interface Presenter {
        void requestLoadPokemonList();


        void onSucessRequestPokemon(ResponsePokemon responsePokemon);

        void onFailureRequestPokemon(Throwable t);
    }

    interface View {

        void onSucessRequestPokemon(ResponsePokemon responsePokemon);
        void onFailureRequestPokemon(Throwable t);



    }

    interface Repository {
        void resquestPokemon();
    }
}
