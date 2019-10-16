package com.benboonya.pokemoninfo.common.repositpry

import androidx.paging.LivePagedListBuilder
import com.benboonya.pokemoninfo.common.Config
import com.benboonya.pokemoninfo.common.datasource.PagedListDataSourceFactory
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.model.PagedListResult
import com.benboonya.pokemoninfo.common.network.PokemonApiBuilder
import java.util.concurrent.Executors
import javax.inject.Inject

class PagedListItemRepository @Inject constructor(pokemonApiBuilder: PokemonApiBuilder) {

    private val pokemonApi = pokemonApiBuilder.build()

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