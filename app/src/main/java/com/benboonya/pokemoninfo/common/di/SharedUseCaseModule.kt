package com.benboonya.pokemoninfo.common.di

import com.benboonya.pokemoninfo.common.usecase.GetPagedListUseCase
import org.koin.dsl.module

val sharedUseCaseModule = module {
    factory { GetPagedListUseCase(get()) }
}