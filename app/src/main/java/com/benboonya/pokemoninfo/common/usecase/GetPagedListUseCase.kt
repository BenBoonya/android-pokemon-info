package com.benboonya.pokemoninfo.common.usecase

import com.benboonya.pokemoninfo.common.repositpry.PagedListItemRepository

class GetPagedListUseCase(private val repository: PagedListItemRepository) {

    operator fun invoke(dataType: String) = repository.getPagedList(dataType)
}
