package com.benboonya.pokemoninfo.common.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.databinding.GenericItemViewHolderBinding

class PagedItemListAdapter : PagedListAdapter<GenericListItem, GenericItemViewHolder>(GenericListItem.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GenericItemViewHolder(GenericItemViewHolderBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: GenericItemViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}