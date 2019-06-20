package com.benboonya.pokemoninfo.pokemon.di

import com.benboonya.pokemoninfo.pokemon.ui.list.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokemonModule = module {

    viewModel { PokemonListViewModel(get()) }
}
