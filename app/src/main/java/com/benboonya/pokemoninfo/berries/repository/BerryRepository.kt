package com.benboonya.pokemoninfo.berries.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benboonya.pokemoninfo.berries.model.Berry
import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.common.extension.enqueue
import com.benboonya.pokemoninfo.common.util.Either

class BerryRepository(private val api: PokemonApi) {

    fun getBerryDetail(url: String): LiveData<Either<String?, Berry>> {
        val response = MutableLiveData<Either<String?, Berry>>()
        api.getBerryDetail(url).enqueue({
            it?.let { pokemon ->
                response.value = Either.Right(pokemon)
            }
        }, {
            response.value = Either.Left(it)
        })
        return response
    }
}