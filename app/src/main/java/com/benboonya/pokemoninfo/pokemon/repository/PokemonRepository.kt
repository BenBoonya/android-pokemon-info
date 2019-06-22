package com.benboonya.pokemoninfo.pokemon.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.common.extension.enqueue
import com.benboonya.pokemoninfo.common.util.Either
import com.benboonya.pokemoninfo.pokemon.model.Pokemon

class PokemonRepository(private val api: PokemonApi) {

    fun getPokemonDetail(url: String): LiveData<Either<String?, Pokemon>> {
        val response = MutableLiveData<Either<String?, Pokemon>>()
        api.getPokemonDetail(url).enqueue({
            it?.let { pokemon ->
                response.value = Either.Right(pokemon)
            }
        }, {
            response.value = Either.Left(it)
        })
        return response
    }
}