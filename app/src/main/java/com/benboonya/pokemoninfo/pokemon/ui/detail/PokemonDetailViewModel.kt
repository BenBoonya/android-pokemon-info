package com.benboonya.pokemoninfo.pokemon.ui.detail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import com.benboonya.pokemoninfo.pokemon.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    val pokemonDetail: MutableLiveData<Pokemon> = MutableLiveData()

    val isLoading: MediatorLiveData<Boolean> = MediatorLiveData()

    fun assignArgument(args: PokemonDetailBottomSheetDialogFragmentArgs) {
        getPokemonDetail(args.url)
    }

    private fun getPokemonDetail(url: String) = viewModelScope.launch {
        isLoading.value = true
        pokemonDetail.value = getPokemonDetailUseCase(url)
        isLoading.value = false
    }
}