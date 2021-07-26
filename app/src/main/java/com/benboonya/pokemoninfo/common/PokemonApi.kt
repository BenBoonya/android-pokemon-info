package com.benboonya.pokemoninfo.common

import com.benboonya.pokemoninfo.berries.model.Berry
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.model.PaginatedWrapper
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApi {

    @GET("{data_type}")
    suspend fun getInitialDataList(@Path(value = "data_type") dataType: String): PaginatedWrapper<GenericListItem>

    @GET
    suspend fun getDataList(@Url url: String): PaginatedWrapper<GenericListItem>

    @GET
    suspend fun getPokemonDetail(@Url url: String): Pokemon

    @GET
    suspend fun getBerryDetail(@Url url: String): Berry
}