package com.benboonya.pokemoninfo.common

import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.model.PaginatedWrapper
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApi {

    @GET("{data_type}")
    fun getInitialDataList(@Path(value = "data_type") dataType: String): Call<PaginatedWrapper<GenericListItem>>

    @GET
    fun getDataList(@Url url: String): Call<PaginatedWrapper<GenericListItem>>

    @GET
    fun getPokemonDetail(@Url url: String): Call<Pokemon>
}