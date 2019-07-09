package com.benboonya.pokemoninfo.common.di

import com.benboonya.pokemoninfo.common.repositpry.PagedListItemRepository
import org.koin.dsl.module

val sharedRepositoryModule = module {
    single { PagedListItemRepository(get()) }
}