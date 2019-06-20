package com.benboonya.pokemoninfo.pokemon.repository

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.benboonya.pokemoninfo.common.Config
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.datasource.PagedListDataSourceFactory
import com.benboonya.pokemoninfo.common.model.PagedListResult

import java.util.concurrent.Executors

class PokemonRepository(private val pokemonApi: PokemonApi) {

    fun getPokemonList(): PagedListResult<GenericListItem> {
        val pokemonListDataSourceFactory = PagedListDataSourceFactory("pokemon", pokemonApi)
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