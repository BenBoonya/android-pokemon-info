package com.benboonya.pokemoninfo.berries.ui.detail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benboonya.pokemoninfo.berries.model.Berry
import com.benboonya.pokemoninfo.berries.usecase.GetBerryDetailUseCase
import javax.inject.Inject

class BerryDetailViewModel @Inject constructor(
    private val getBerryDetailUseCase: GetBerryDetailUseCase
) : ViewModel() {

    val berryDetail: MutableLiveData<Berry> = MutableLiveData()

    val isLoading: MediatorLiveData<Boolean> = MediatorLiveData()

    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun assignArgument(args: BerryDetailFragmentArgs) {
        getBerryDetail(args.url)
    }

    private fun getBerryDetail(url: String) {

        getBerryDetailUseCase(url).let { liveData ->
            isLoading.value = true
            isLoading.addSource(liveData) {
                isLoading.value = false
                it.either(this::getBerryDetailFail, this::getBerryDetailSuccess)
            }
        }
    }

    private fun getBerryDetailSuccess(berry: Berry?) {
        berryDetail.value = berry
    }

    private fun getBerryDetailFail(message: String?) {
        errorMessage.value = message
    }

}