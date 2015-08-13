package com.ivankocijan.hellomvvm.mvp.interactor;

import com.ivankocijan.hellomvvm.mvp.listener.ResponseListener;
import com.ivankocijan.hellomvvm.model.Pokedex;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public interface PokemonListInteractor {

    void getPokedex(ResponseListener<Pokedex> listener);


}
