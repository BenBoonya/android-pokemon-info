package com.benboonya.pokemoninfo.pokemon.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.benboonya.pokemoninfo.databinding.PokemonItemViewHolderBinding
import com.benboonya.pokemoninfo.pokemon.model.Pokemon

class PokemonListAdapter : PagedListAdapter<Pokemon, PokemonViewHolder>(Pokemon.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(PokemonItemViewHolderBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}