package com.benboonya.pokemoninfo.common

import com.benboonya.pokemoninfo.common.modei.PaginatedWrapper
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonApi {

    @GET("pokemon")
    fun getInitialPokemonList(): Call<PaginatedWrapper<Pokemon>>

    @GET
    fun getPokemonList(@Url url: String): Call<PaginatedWrapper<Pokemon>>
}