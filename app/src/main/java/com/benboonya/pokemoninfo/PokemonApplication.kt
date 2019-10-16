package com.benboonya.pokemoninfo

import com.benboonya.pokemoninfo.common.di.DaggerPokemonInfoComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class PokemonApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<PokemonApplication> {
        return DaggerPokemonInfoComponent.builder().build()
    }
}