package com.example.pokedex.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.pokedex.view.adapter.AdapterListaPokemons;
import com.example.pokedex.controlers.PokemonModel;
import com.example.pokedex.controlers.PokemonPresenter;
import com.example.pokedex.model.Pokemons;
import com.example.pokedex.R;
import com.example.pokedex.controlers.ResponsePokemon;
import com.example.pokedex.view.dao.ListPokemonDao;

import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity implements PokemonModel.View {
    //
    PokemonPresenter presenter;
    //Requisição backend

    private ListView listaPokemons;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PokemonPresenter(this, this);
        presenter.requestLoadPokemonList();

    }

    @Override
    public void onFailureRequestPokemon(Throwable t) {

    }

    @Override
    public void onSucessRequestPokemon(ResponsePokemon responsePokemon) {
        ListPokemonDao.listaPokemon = responsePokemon.getPokemons();
        listaPokemons =  findViewById(R.id.listViewPokemons);
        listaPokemons.setAdapter(new AdapterListaPokemons(ListPokemonDao.listaPokemon,this) );


    }
}
