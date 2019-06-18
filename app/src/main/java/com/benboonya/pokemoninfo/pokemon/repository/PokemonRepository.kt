package com.benboonya.pokemoninfo.pokemon.repository

import com.benboonya.pokemoninfo.common.PokemonApi
import com.benboonya.pokemoninfo.pokemon.model.Pokemon

class PokemonRepository(private val pokemonApi: PokemonApi) {

    fun getPokemonList() = ArrayList<Pokemon>()

}