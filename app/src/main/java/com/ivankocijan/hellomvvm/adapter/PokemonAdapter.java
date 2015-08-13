package com.ivankocijan.hellomvvm.adapter;

import com.ivankocijan.hellomvvm.R;
import com.ivankocijan.hellomvvm.adapter.listener.PokemonClickListener;
import com.ivankocijan.hellomvvm.databinding.ListItemPokemonBinding;
import com.ivankocijan.hellomvvm.model.Pokemon;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> pokemonList;
    private PokemonClickListener listener;

    public PokemonAdapter(List<Pokemon> pokemonList, PokemonClickListener listener) {
        this.pokemonList = pokemonList;
        this.listener = listener;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemPokemonBinding itemPokemonBinding = DataBindingUtil.inflate(inflater, R.layout.list_item_pokemon, parent, false);
        return new PokemonViewHolder(itemPokemonBinding);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, final int position) {

        final Pokemon pokemon = pokemonList.get(position);
        holder.getBinding().setPokemon(pokemon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onPokemonClick(pokemon.getPokedexId());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {

        private ListItemPokemonBinding binding;

        public PokemonViewHolder(ListItemPokemonBinding v) {
            super(v.getRoot());
            this.binding = v;
        }


        public ListItemPokemonBinding getBinding() {
            return binding;
        }
    }

}
