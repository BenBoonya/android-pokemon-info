package com.benboonya.pokemoninfo.pokemon.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.benboonya.pokemoninfo.databinding.PokemonItemViewHolderBinding
import com.benboonya.pokemoninfo.pokemon.model.Pokemon

class PokemonViewHolder(
        private val binding: PokemonItemViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon) {
        binding.pokenon = pokemon
    }
}