package com.benboonya.pokemoninfo.common.repositpry

import androidx.paging.LivePagedListBuilder
import com.benboonya.pokemoninfo.common.Config
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.common.datasource.PagedListDataSourceFactory
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.model.PagedListResult
import java.util.concurrent.Executors

class PagedListItemRepository(private val pokemonApi: PokemonApi) {

    fun getPagedList(dataType: String): PagedListResult<GenericListItem> {
        val pokemonListDataSourceFactory = PagedListDataSourceFactory(dataType, pokemonApi)
        val result = LivePagedListBuilder(pokemonListDataSourceFactory, Config.PagedList.config)
                .setFetchExecutor(Executors.newFixedThreadPool(3))
                .build()

        return PagedListResult(
                result,
                pokemonListDataSourceFactory.isInitialLoading,
                pokemonListDataSourceFactory.isLoading,
                pokemonListDataSourceFactory.networkError
        )
    }
}