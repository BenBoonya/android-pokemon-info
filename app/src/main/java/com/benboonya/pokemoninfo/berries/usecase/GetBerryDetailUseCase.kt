package com.benboonya.pokemoninfo.berries.usecase

import com.benboonya.pokemoninfo.berries.repository.BerryRepository
import javax.inject.Inject

class GetBerryDetailUseCase @Inject constructor(
    private val repository: BerryRepository
) {
    operator fun invoke(url: String) = repository.getBerryDetail(url)
}