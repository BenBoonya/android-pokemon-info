package com.benboonya.pokemoninfo.pokemon.di

import com.benboonya.pokemoninfo.pokemon.repository.PokemonRepository
import com.benboonya.pokemoninfo.pokemon.ui.list.PokemonListViewModel
import com.benboonya.pokemoninfo.pokemon.usecase.GetPokemonListUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val pokemonModule = module {
    single { PokemonRepository(get()) }
    factory { GetPokemonListUseCase(get()) }

    viewModel { PokemonListViewModel(get()) }
}
