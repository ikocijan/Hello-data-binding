package com.ivankocijan.hellomvvm.viewModel;

import com.ivankocijan.hellomvvm.R;
import com.ivankocijan.hellomvvm.model.Pokemon;
import com.ivankocijan.hellomvvm.mvp.interactor.PokemonDetailsInteractor;
import com.ivankocijan.hellomvvm.mvp.interactor.impl.PokemonDetailsInteractorImpl;
import com.ivankocijan.hellomvvm.mvp.listener.ResponseListener;

import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 12.08.15.
 */
public class PokemonDetailsViewModel extends BaseObservable {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> attack = new ObservableField<>();
    public ObservableField<String> defense = new ObservableField<>();
    public ObservableInt loader = new ObservableInt();
    public ObservableInt showError = new ObservableInt();
    public ObservableField<String> error = new ObservableField<>();

    private Resources resources;
    private PokemonDetailsInteractor interactor;

    public PokemonDetailsViewModel(Resources resources) {
        this.resources = resources;
        this.interactor = new PokemonDetailsInteractorImpl();
        loader.set(View.VISIBLE);
        showError.set(View.GONE);
    }

    public void loadPokemon(int pokemonId) {

        interactor.getPokemonDetails(pokemonId, new ResponseListener<Pokemon>() {
            @Override
            public void onSuccess(Pokemon response) {
                name.set(response.getName());
                attack.set(resources.getString(R.string.attack) + response.getAttack());
                defense.set(resources.getString(R.string.defense) + response.getDefense());
                loader.set(View.GONE);

            }

            @Override
            public void onError(String apiError) {
                loader.set(View.GONE);
                error.set(apiError);
                showError.set(View.VISIBLE);
            }
        });
    }


}


