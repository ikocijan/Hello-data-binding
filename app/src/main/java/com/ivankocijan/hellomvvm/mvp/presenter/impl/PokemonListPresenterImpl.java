package com.ivankocijan.hellomvvm.mvp.presenter.impl;

import com.ivankocijan.hellomvvm.mvp.interactor.PokemonListInteractor;
import com.ivankocijan.hellomvvm.mvp.interactor.impl.PokemonListInteractorImpl;
import com.ivankocijan.hellomvvm.mvp.listener.ResponseListener;
import com.ivankocijan.hellomvvm.mvp.presenter.PokemonListPresenter;
import com.ivankocijan.hellomvvm.mvp.view.PokemonListView;
import com.ivankocijan.hellomvvm.model.Pokedex;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public class PokemonListPresenterImpl implements PokemonListPresenter {

    private PokemonListView pokemonListView;
    private PokemonListInteractor interactor;

    public PokemonListPresenterImpl(PokemonListView pokemonListView) {
        this.pokemonListView = pokemonListView;
        this.interactor = new PokemonListInteractorImpl();
    }

    @Override
    public void loadPokemonList() {

        pokemonListView.showLoader();
        
        interactor.getPokedex(new ResponseListener<Pokedex>() {
            @Override
            public void onSuccess(Pokedex response) {
                pokemonListView.hideLoader();
                pokemonListView.onPokemonsLoaded(response.getPokemonList());
            }

            @Override
            public void onError(String error) {
                pokemonListView.hideLoader();
                pokemonListView.showMessage(error);
            }
        });

    }
}
