package com.example.pokedex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokedex.model.Pokemons;
import com.example.pokedex.R;


import java.util.List;

public class AdapterListaPokemons  extends BaseAdapter {

        private List<Pokemons> pokemons;
        private final Context context;


    public AdapterListaPokemons(List<Pokemons> pacotes,Context context){
            this.pokemons = pacotes;
            this.context = context;
        }

    public AdapterListaPokemons(Context context) {
        this.context = context;
    }

    @Override
        public int getCount() {
            return pokemons.size();
        }

        @Override
        public Object getItem(int posicao) {
            return pokemons.get(posicao);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int posicao, View view, ViewGroup parent) {

            View viewCriada = LayoutInflater.from(context).inflate(R.layout.content_pokemon,parent,false);

            Pokemons pokemons = this.pokemons.get(posicao);


            ImageView imagem = viewCriada.findViewById(R.id.imagem_pokemons);
            Glide.with(context)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+pokemons.getNumber()+".png")
            .crossFade()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imagem);

            TextView nomePokemon = viewCriada.findViewById(R.id.texto_pokemons);
            String name = pokemons.getName();
            String letra = name.substring(0, 1).toUpperCase() + name.substring(1);
            nomePokemon.setText(letra);


            return viewCriada;
        }



}
