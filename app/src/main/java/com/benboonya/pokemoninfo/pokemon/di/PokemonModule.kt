package com.benboonya.pokemoninfo.pokemon.di

import com.benboonya.pokemoninfo.pokemon.repository.PokemonRepository
import com.benboonya.pokemoninfo.pokemon.ui.list.PokemonListViewModel
import com.benboonya.pokemoninfo.pokemon.usecase.GetPokenListUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val pokemonModule = module {
    scope(named("POKEMON")) {
        scoped { PokemonRepository(get()) }
        scoped { GetPokenListUseCase(get()) }

        viewModel { PokemonListViewModel(get()) }
    }
}