package com.benboonya.pokemoninfo.pokemon.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.benboonya.pokemoninfo.common.util.SingleLiveEvent

class PokemonPagedListResult(
    val result: LiveData<PagedList<Pokemon>> = MutableLiveData<PagedList<Pokemon>>(),
    val isInitialLoading: LiveData<Boolean> = MutableLiveData(),
    val isLoading: LiveData<Boolean> = MutableLiveData(),
    val networkError: LiveData<String?> = SingleLiveEvent()
) {

}