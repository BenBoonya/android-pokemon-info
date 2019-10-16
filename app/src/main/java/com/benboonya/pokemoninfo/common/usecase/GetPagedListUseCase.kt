package com.benboonya.pokemoninfo.common.usecase

import com.benboonya.pokemoninfo.common.repositpry.PagedListItemRepository
import javax.inject.Inject

class GetPagedListUseCase @Inject constructor(private val repository: PagedListItemRepository) {

    operator fun invoke(dataType: String) = repository.getPagedList(dataType)
}
