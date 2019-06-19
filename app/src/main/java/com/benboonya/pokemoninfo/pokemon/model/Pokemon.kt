package com.benboonya.pokemoninfo.pokemon.model

import androidx.recyclerview.widget.DiffUtil

data class Pokemon(
        val name: String,
        val url: String
) {
    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Pokemon> = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean = (oldItem.url == newItem.url)

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean = oldItem == newItem
        }
    }
}