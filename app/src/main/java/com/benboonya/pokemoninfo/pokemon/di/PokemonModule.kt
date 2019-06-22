package com.benboonya.pokemoninfo.pokemon.di

import com.benboonya.pokemoninfo.pokemon.repository.PokemonRepository
import com.benboonya.pokemoninfo.pokemon.ui.detail.PokemonDetailViewModel
import com.benboonya.pokemoninfo.pokemon.ui.list.PokemonListViewModel
import com.benboonya.pokemoninfo.pokemon.usecase.GetPokemonDetailUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokemonModule = module {

    viewModel { PokemonListViewModel(get()) }
    viewModel { PokemonDetailViewModel(get()) }

    factory { GetPokemonDetailUseCase(get()) }
    single { PokemonRepository(get()) }
}
