package com.benboonya.pokemoninfo.common.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.databinding.GenericItemViewHolderBinding

class PagedItemListAdapter(private val onItemClick: (GenericListItem) -> Unit) :
    PagingDataAdapter<GenericListItem, GenericItemViewHolder>(GenericListItem.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GenericItemViewHolder(GenericItemViewHolderBinding.inflate(layoutInflater, parent, false)) {
            getItem(it)?.let { item -> onItemClick(item) }
        }
    }

    override fun onBindViewHolder(holder: GenericItemViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}