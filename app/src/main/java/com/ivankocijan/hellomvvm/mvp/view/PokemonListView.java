package com.ivankocijan.hellomvvm.mvp.view;

import com.ivankocijan.hellomvvm.model.Pokemon;

import java.util.List;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 12.08.15.
 */
public interface PokemonListView extends BaseView {

    void onPokemonsLoaded(List<Pokemon> pokemonList);

}
