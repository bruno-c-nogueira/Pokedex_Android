package com.example.pokedex.model;

import com.google.gson.annotations.SerializedName;

public class Pokemons {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    private int number;

    public int getNumber() {
        String[] urlParts = url.split("/");
        return Integer.parseInt(urlParts[urlParts.length -1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
