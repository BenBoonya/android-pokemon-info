package com.benboonya.pokemoninfo.pokemon.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.databinding.GenericItemViewHolderBinding

class PokemonListAdapter : PagedListAdapter<GenericListItem, PokemonViewHolder>(GenericListItem.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(GenericItemViewHolderBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}