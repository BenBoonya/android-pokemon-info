package com.benboonya.pokemoninfo.berries.di

import com.benboonya.pokemoninfo.berries.repository.BerryRepository
import com.benboonya.pokemoninfo.berries.ui.detail.BerryDetailViewModel
import com.benboonya.pokemoninfo.berries.ui.list.BerryListViewModel
import com.benboonya.pokemoninfo.berries.usecase.GetBerryDetailUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val berryModule = module {
    viewModel { BerryDetailViewModel(get()) }
    viewModel { BerryListViewModel(get()) }
    single { BerryRepository(get()) }
    factory { GetBerryDetailUseCase(get()) }
}