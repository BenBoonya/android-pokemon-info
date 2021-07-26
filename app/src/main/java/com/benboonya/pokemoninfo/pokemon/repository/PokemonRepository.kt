package com.benboonya.pokemoninfo.pokemon.repository

import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {

    suspend fun getPokemonDetail(url: String): Pokemon? {
        return try {
            val response = api.getPokemonDetail(url)
            response
        } catch (ex: Exception) {
            null
        }
    }
}