package com.benboonya.pokemoninfo.pokemon.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.common.extension.enqueue
import com.benboonya.pokemoninfo.common.modei.PaginatedWrapper
import com.benboonya.pokemoninfo.common.util.SingleLiveEvent
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListDataSource(
        private val api: PokemonApi
) : PageKeyedDataSource<String, Pokemon>() {

    val isLoading = MutableLiveData<Boolean>()

    val isInitialLoading = MutableLiveData<Boolean>()

    val networkError = SingleLiveEvent<String?>()


    override fun loadInitial(
            params: LoadInitialParams<String>,
            callback: LoadInitialCallback<String, Pokemon>
    ) {
        isInitialLoading.postValue(true)
        api.getInitialPokemonList().enqueue({
            isInitialLoading.postValue(false)
            it?.let { response ->
                callback.onResult(response.results, 0, response.count, response.previous, response.next)
            }
        }, this::setInitialError)
    }


    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Pokemon>) {
        isLoading.postValue(true)
        api.getPokemonList(params.key).enqueue({
            it?.let { response ->
                isLoading.postValue(false)
                callback.onResult(response.results, response.next)
            }
        }, this::setError)
    }


    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Pokemon>) {

    }

    private fun setInitialError(errorMessage: String?) {
        isInitialLoading.postValue(false)
        networkError.postValue(errorMessage)
    }

    private fun setError(errorMessage: String?) {
        isLoading.postValue(false)
        networkError.postValue(errorMessage)
    }

}