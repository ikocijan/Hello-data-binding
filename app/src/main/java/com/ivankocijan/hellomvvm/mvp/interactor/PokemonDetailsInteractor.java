package com.ivankocijan.hellomvvm.mvp.interactor;

import com.ivankocijan.hellomvvm.model.Pokemon;
import com.ivankocijan.hellomvvm.mvp.listener.ResponseListener;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 12.08.15.
 */
public interface PokemonDetailsInteractor {

    void getPokemonDetails(int pokemonId, ResponseListener<Pokemon> listener);

}
