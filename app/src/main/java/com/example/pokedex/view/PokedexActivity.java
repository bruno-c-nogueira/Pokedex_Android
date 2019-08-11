package com.example.pokedex.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.pokedex.adapter.AdapterListaPokemons;
import com.example.pokedex.controlers.PokemonModel;
import com.example.pokedex.controlers.PokemonPresenter;
import com.example.pokedex.model.Pokemons;
import com.example.pokedex.R;
import com.example.pokedex.controlers.ResponsePokemon;

import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity implements PokemonModel.View {
    //
    PokemonPresenter presenter;
    //Requisição backend
    private ArrayList<Pokemons> pokemons;
    private ListView listaPokemons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PokemonPresenter(this, this);
        presenter.requestLoadSpecies();


    }

    @Override
    public void onSucessRequestPokemon(ResponsePokemon responsePokemon) {

        pokemons = responsePokemon.getPokemons();
        listaPokemons =  findViewById(R.id.listViewPokemons);
        listaPokemons.setAdapter(new AdapterListaPokemons(pokemons,this) );
    }
}
