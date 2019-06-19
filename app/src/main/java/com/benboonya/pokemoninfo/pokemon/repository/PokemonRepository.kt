package com.benboonya.pokemoninfo.pokemon.repository

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.pokemon.datasource.PokemonListDataSourceFactory
import com.benboonya.pokemoninfo.pokemon.model.PokemonPagedListResult

import java.util.concurrent.Executors

class PokemonRepository(private val pokemonApi: PokemonApi) {

    fun getPokemonList(): PokemonPagedListResult {
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(PAGE_SIZE * 2)
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE)
            .setPrefetchDistance(PAGE_SIZE)
            .build()
        val pokemonListDataSourceFactory = PokemonListDataSourceFactory(pokemonApi)
        val result = LivePagedListBuilder(pokemonListDataSourceFactory, config)
            .setFetchExecutor(Executors.newFixedThreadPool(3))
            .build()

        return PokemonPagedListResult(
            result,
            pokemonListDataSourceFactory.isInitialLoading,
            pokemonListDataSourceFactory.isLoading,
            pokemonListDataSourceFactory.networkError
        )
    }

}