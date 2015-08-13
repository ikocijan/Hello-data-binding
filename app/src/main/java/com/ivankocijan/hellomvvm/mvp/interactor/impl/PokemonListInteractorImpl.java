package com.ivankocijan.hellomvvm.mvp.interactor.impl;

import com.ivankocijan.hellomvvm.mvp.interactor.PokemonListInteractor;
import com.ivankocijan.hellomvvm.mvp.listener.ResponseListener;
import com.ivankocijan.hellomvvm.model.Pokedex;
import com.ivankocijan.hellomvvm.retrofit.ApiManager;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public class PokemonListInteractorImpl implements PokemonListInteractor {

    @Override
    public void getPokedex(final ResponseListener<Pokedex> listener) {

        ApiManager.getRestClient().getPokedex(new Callback<Pokedex>() {
            @Override
            public void success(Pokedex pokedex, Response response) {
                listener.onSuccess(pokedex);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onError("Error fetching data");
            }
        });

    }
}
