package com.benboonya.pokemoninfo.pokemon.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import com.benboonya.pokemoninfo.pokemon.model.PokemonPagedListResult
import com.benboonya.pokemoninfo.pokemon.usecase.GetPokemonListUseCase

class PokemonListViewModel(private val getPokemonListUseCase: GetPokemonListUseCase) : ViewModel() {

    private val pokemonPagedListResult: MutableLiveData<PokemonPagedListResult> = MutableLiveData()

    val pokemonList: LiveData<PagedList<Pokemon>> = Transformations.switchMap(pokemonPagedListResult) { it.result }

    val isInitialLoading: LiveData<Boolean> = Transformations.switchMap(pokemonPagedListResult) { it.isInitialLoading }

    val networkError: LiveData<String?> = Transformations.switchMap(pokemonPagedListResult) { it.networkError }

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        pokemonPagedListResult.value = getPokemonListUseCase()
    }
}