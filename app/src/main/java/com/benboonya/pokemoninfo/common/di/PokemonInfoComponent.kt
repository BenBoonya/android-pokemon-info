package com.benboonya.pokemoninfo.common.di

import com.benboonya.pokemoninfo.PokemonApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        FragmentModule::class
    ]
)
interface PokemonInfoComponent : AndroidInjector<PokemonApplication> {

    @Component.Builder
    interface Builder {
        fun build(): PokemonInfoComponent
    }
}