package com.ivankocijan.hellomvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public class Pokedex {

    @SerializedName("pokemon")
    List<Pokemon> pokemonList;

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
