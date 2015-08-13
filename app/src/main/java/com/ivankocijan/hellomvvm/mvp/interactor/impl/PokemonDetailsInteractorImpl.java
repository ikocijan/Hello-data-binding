package com.ivankocijan.hellomvvm.mvp.interactor.impl;

import com.ivankocijan.hellomvvm.model.Pokemon;
import com.ivankocijan.hellomvvm.mvp.interactor.PokemonDetailsInteractor;
import com.ivankocijan.hellomvvm.mvp.listener.ResponseListener;
import com.ivankocijan.hellomvvm.retrofit.ApiManager;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 12.08.15.
 */
public class PokemonDetailsInteractorImpl implements PokemonDetailsInteractor {

    @Override
    public void getPokemonDetails(int pokemonId, final ResponseListener<Pokemon> listener) {

        ApiManager.getRestClient().getPokemon(pokemonId, new Callback<Pokemon>() {
            @Override
            public void success(Pokemon pokemon, Response response) {
                listener.onSuccess(pokemon);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onError("Error downloading data");
            }
        });


    }
}
