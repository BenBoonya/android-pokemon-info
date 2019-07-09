package com.benboonya.pokemoninfo.common.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.common.extension.enqueue
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.util.SingleLiveEvent

class PagedListDataSource(
        private val dataType: String,
        private val api: PokemonApi
) : PageKeyedDataSource<String, GenericListItem>() {

    val isLoading = MutableLiveData<Boolean>()

    val isInitialLoading = MutableLiveData<Boolean>()

    val networkError = SingleLiveEvent<String?>()

    @Suppress("UNCHECKED_CAST")
    override fun loadInitial(
            params: LoadInitialParams<String>,
            callback: LoadInitialCallback<String, GenericListItem>
    ) {
        isInitialLoading.postValue(true)
        api.getInitialDataList(dataType).enqueue({
            isInitialLoading.postValue(false)
            it?.let { response ->
                callback.onResult(response.results, 0, response.count, response.previous, response.next)
            }
        }, this::setInitialError)
    }

    @Suppress("UNCHECKED_CAST")
    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, GenericListItem>) {
        isLoading.postValue(true)
        api.getDataList(params.key).enqueue({
            it?.let { response ->
                isLoading.postValue(false)
                callback.onResult(response.results, response.next)
            }
        }, this::setError)
    }


    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, GenericListItem>) {

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