package com.benboonya.pokemoninfo.pokemon.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.databinding.GenericItemViewHolderBinding

class PokemonViewHolder(
        private val binding: GenericItemViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: GenericListItem) {
        binding.item = pokemon
    }
}