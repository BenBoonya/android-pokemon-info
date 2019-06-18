package com.benboonya.pokemoninfo.common

import com.benboonya.pokemoninfo.common.modei.PaginatedWrapper
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon")
    fun getProfile(): Call<PaginatedWrapper<Pokemon>>

}