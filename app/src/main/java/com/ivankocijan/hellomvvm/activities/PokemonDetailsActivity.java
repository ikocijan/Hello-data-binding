package com.ivankocijan.hellomvvm.activities;

import com.ivankocijan.hellomvvm.R;
import com.ivankocijan.hellomvvm.viewModel.PokemonDetailsViewModel;
import com.ivankocijan.hellomvvm.databinding.ActivityPokemonDetailsBinding;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

public class PokemonDetailsActivity extends BaseActivity {

    private static final String EXTRA_POKEMON_ID = "pokemonId";

    private PokemonDetailsViewModel viewModel;
    private ActivityPokemonDetailsBinding binding;

    public static Intent newIntent(Activity activity, int pokemonId) {

        Intent intent = new Intent(activity, PokemonDetailsActivity.class);
        intent.putExtra(EXTRA_POKEMON_ID, pokemonId);
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pokemon_details);
        viewModel = new PokemonDetailsViewModel(getResources());
        binding.setPokemonViewModel(viewModel);
        viewModel.loadPokemon(getIntent().getIntExtra(EXTRA_POKEMON_ID, 1));

    }


}
