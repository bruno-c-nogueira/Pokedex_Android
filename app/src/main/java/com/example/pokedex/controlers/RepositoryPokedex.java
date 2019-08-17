package com.example.pokedex.controlers;

import android.content.Context;
import android.util.Log;

import com.example.pokedex.model.Pokemons;
import com.example.pokedex.service.RetrofitInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RepositoryPokedex implements PokemonModel.Repository {
    Context context;
    PokemonModel.Presenter presenter;

    public RepositoryPokedex(Context context, PokemonModel.Presenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }



    @Override
    public void resquestPokemon() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Call<ResponsePokemon> call = retrofitInterface.getPokemons();

        call.enqueue(new Callback<ResponsePokemon>() {
            @Override
            public void onResponse(Call<ResponsePokemon> call, Response<ResponsePokemon> response) {
                if (response.code() == 200) {
                    ResponsePokemon pokemonResposta = response.body();
                    ArrayList<Pokemons> pokemons = pokemonResposta.getPokemons();

//                    for (int i = 0; i < pokemons.size() ; i++) {
//                        Pokemons p = pokemons.get(i);
//                        Log.i("POKEMONS", "onResponse: "+p.getName());
//                    }
                    presenter.onSucessRequestPokemon(response.body());

                    // Do awesome stuff
                } else {
                    // Handle other response codes

                }
            }

            @Override
            public void onFailure(Call<ResponsePokemon> call, Throwable t) {
                presenter.onFailureRequestPokemon(t);
            }
        });



        }
    }

