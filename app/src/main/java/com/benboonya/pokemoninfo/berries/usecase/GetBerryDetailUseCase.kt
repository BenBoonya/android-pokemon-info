package com.benboonya.pokemoninfo.berries.usecase

import com.benboonya.pokemoninfo.berries.repository.BerryRepository

class GetBerryDetailUseCase(private val repository: BerryRepository) {

    operator fun invoke(url: String) = repository.getBerryDetail(url)
}