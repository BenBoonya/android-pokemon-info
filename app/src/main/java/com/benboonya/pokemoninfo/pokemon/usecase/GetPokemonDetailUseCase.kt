package com.benboonya.pokemoninfo.pokemon.usecase

import com.benboonya.pokemoninfo.pokemon.repository.PokemonRepository

class GetPokemonDetailUseCase(private val repository: PokemonRepository) {

    operator fun invoke(url: String) = repository.getPokemonDetail(url)
}