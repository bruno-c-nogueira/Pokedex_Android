package com.example.pokedex.controlers;

public interface PokemonModel {
    interface Presenter {
        void requestLoadSpecies();


        void onSucessRequestPokemon(ResponsePokemon responsePokemon);
    }

    interface View {

        void onSucessRequestPokemon(ResponsePokemon responsePokemon);



    }

    interface Repository {
        void resquestPokemon();
    }
}
