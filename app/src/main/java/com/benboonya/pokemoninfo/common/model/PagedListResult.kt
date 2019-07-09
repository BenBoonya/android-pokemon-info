package com.benboonya.pokemoninfo.common.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.benboonya.pokemoninfo.common.util.SingleLiveEvent

class PagedListResult<T>(
        val result: LiveData<PagedList<T>> = MutableLiveData<PagedList<T>>(),
        val isInitialLoading: LiveData<Boolean> = MutableLiveData(),
        val isLoading: LiveData<Boolean> = MutableLiveData(),
        val networkError: LiveData<String?> = SingleLiveEvent()
)