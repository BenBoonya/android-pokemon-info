package com.benboonya.pokemoninfo.common.di

import com.benboonya.pokemoninfo.berries.ui.detail.BerryDetailFragment
import com.benboonya.pokemoninfo.berries.ui.list.BerryListFragment
import com.benboonya.pokemoninfo.pokemon.ui.detail.PokemonDetailBottomSheetDialogFragment
import com.benboonya.pokemoninfo.pokemon.ui.list.PokemonListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun pokemonListFragment() : PokemonListFragment

    @ContributesAndroidInjector
    fun pokemonDetailDialogFragment(): PokemonDetailBottomSheetDialogFragment

    @ContributesAndroidInjector
    fun berryDetailFragment(): BerryDetailFragment

    @ContributesAndroidInjector
    fun berryListFragment(): BerryListFragment
}