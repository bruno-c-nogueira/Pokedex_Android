package com.example.pokedex.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ListView;

import com.example.pokedex.database.PokemonDatabase;
import com.example.pokedex.database.RoomPokemonDao;
import com.example.pokedex.model.Pokemon;
import com.example.pokedex.view.adapter.AdapterListaPokemons;
import com.example.pokedex.controlers.PokemonModel;
import com.example.pokedex.controlers.PokemonPresenter;
import com.example.pokedex.R;
import com.example.pokedex.controlers.ResponsePokemon;
import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity implements PokemonModel.View {
    //
    PokemonPresenter presenter;
    RoomPokemonDao dao;
    //Requisição backend

    private ListView listaPokemons;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PokemonPresenter(this, this);
        presenter.requestLoadPokemonList();
        PokemonDatabase dataBase =  PokemonDatabase.getInstance(PokedexActivity.this);
        dao = dataBase.getRoomDao();
        listaPokemons =  findViewById(R.id.listViewPokemons);
        listaPokemons.setAdapter(new AdapterListaPokemons(dao.buscaPokemon(),this) );


    }

    @Override
    public void onFailureRequestPokemon(Throwable t) {

    }

    @Override
    public void onSucessRequestPokemon(ResponsePokemon responsePokemon) {
        ArrayList<Pokemon> pokemons = responsePokemon.getPokemons();
        if (dao.buscaPokemon().size() == 0) {
            dao.salvaPokemon(pokemons);
        }
        dao.editaPokemon(pokemons);


    }
}
