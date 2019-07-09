package com.benboonya.pokemoninfo.common.datasource

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.common.model.GenericListItem

class PagedListDataSourceFactory(
        dataType: String,
        api: PokemonApi
) : DataSource.Factory<String, GenericListItem>() {

    private var pagedListDataSource = PagedListDataSource(dataType, api)

    val isLoading: LiveData<Boolean> = pagedListDataSource.isLoading

    val isInitialLoading: LiveData<Boolean> = pagedListDataSource.isInitialLoading

    val networkError: LiveData<String?> = pagedListDataSource.networkError

    override fun create(): DataSource<String, GenericListItem> = pagedListDataSource

}