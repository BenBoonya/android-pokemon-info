package com.benboonya.pokemoninfo.berries.di

import com.benboonya.pokemoninfo.berries.ui.list.BerryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val berryModule = module {
    viewModel { BerryListViewModel(get()) }
}