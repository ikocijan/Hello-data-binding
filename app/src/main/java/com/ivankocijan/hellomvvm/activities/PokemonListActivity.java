package com.ivankocijan.hellomvvm.activities;

import com.ivankocijan.hellomvvm.R;
import com.ivankocijan.hellomvvm.adapter.PokemonAdapter;
import com.ivankocijan.hellomvvm.adapter.listener.PokemonClickListener;
import com.ivankocijan.hellomvvm.mvp.presenter.PokemonListPresenter;
import com.ivankocijan.hellomvvm.mvp.presenter.impl.PokemonListPresenterImpl;
import com.ivankocijan.hellomvvm.mvp.view.PokemonListView;
import com.ivankocijan.hellomvvm.model.Pokemon;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PokemonListActivity extends BaseActivity implements PokemonListView, PokemonClickListener {

    @Bind(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private PokemonAdapter adapter;

    private PokemonListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_pokemon_list);
        ButterKnife.bind(this);

        initUI();

    }

    private void initUI() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new PokemonListPresenterImpl(this);
        presenter.loadPokemonList();

    }

    @Override
    public void onPokemonsLoaded(List<Pokemon> pokemonList) {

        adapter = new PokemonAdapter(pokemonList, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onPokemonClick(int pokemonId) {
        startActivity(PokemonDetailsActivity.newIntent(this, pokemonId));
    }
}
