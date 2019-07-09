package com.benboonya.pokemoninfo.pokemon.ui.detail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import com.benboonya.pokemoninfo.pokemon.usecase.GetPokemonDetailUseCase

class PokemonDetailViewModel(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    val pokemonDetail: MutableLiveData<Pokemon> = MutableLiveData()

    val isLoading: MediatorLiveData<Boolean> = MediatorLiveData()

    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun assignArgument(args: PokemonDetailBottomSheetDialogFragmentArgs) {
        getPokemonDetail(args.url)
    }

    private fun getPokemonDetail(url: String) {

        getPokemonDetailUseCase(url).let { liveData ->
            isLoading.value = true
            isLoading.addSource(liveData) {
                isLoading.value = false
                it.either(this::getPokemonDetailFail, this::getPokemonDetailSuccess)
            }
        }
    }

    private fun getPokemonDetailSuccess(pokemon: Pokemon?) {
        pokemonDetail.value = pokemon
    }

    private fun getPokemonDetailFail(message: String?) {
        errorMessage.value = message
    }

}