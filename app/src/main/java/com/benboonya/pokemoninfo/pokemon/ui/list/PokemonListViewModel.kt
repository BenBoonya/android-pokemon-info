package com.benboonya.pokemoninfo.pokemon.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.model.PagedListResult
import com.benboonya.pokemoninfo.pokemon.usecase.GetPokemonListUseCase

class PokemonListViewModel(private val getPokemonListUseCase: GetPokemonListUseCase) : ViewModel() {

    private val pagedListResult: MutableLiveData<PagedListResult<GenericListItem>> = MutableLiveData()

    val pokemonList: LiveData<PagedList<GenericListItem>> = Transformations.switchMap(pagedListResult) { it.result }

    val isInitialLoading: LiveData<Boolean> = Transformations.switchMap(pagedListResult) { it.isInitialLoading }

    val networkError: LiveData<String?> = Transformations.switchMap(pagedListResult) { it.networkError }

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        pagedListResult.value = getPokemonListUseCase()
    }
}