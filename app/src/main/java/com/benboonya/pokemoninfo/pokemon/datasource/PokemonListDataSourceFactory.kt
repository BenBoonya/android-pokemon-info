package com.benboonya.pokemoninfo.pokemon.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.DataSource
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.common.util.SingleLiveEvent
import com.benboonya.pokemoninfo.pokemon.model.Pokemon


class PokemonListDataSourceFactory(
        api: PokemonApi
) : DataSource.Factory<String, Pokemon>() {

    private var pokemonListDataSource = PokemonListDataSource(api)

    val isLoading: LiveData<Boolean> = pokemonListDataSource.isLoading

    val isInitialLoading: LiveData<Boolean> = pokemonListDataSource.isInitialLoading

    val networkError: LiveData<String?> = pokemonListDataSource.networkError

    override fun create(): DataSource<String, Pokemon> = pokemonListDataSource

}