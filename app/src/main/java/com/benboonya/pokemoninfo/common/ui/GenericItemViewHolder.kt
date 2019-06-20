package com.benboonya.pokemoninfo.common.ui

import androidx.recyclerview.widget.RecyclerView
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.databinding.GenericItemViewHolderBinding

class GenericItemViewHolder(
        private val binding: GenericItemViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GenericListItem) {
        binding.item = item
    }
}