package com.albertomagalhaes.doggos.domain.usecase

import com.albertomagalhaes.doggos.data.repository.BreedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class FavoriteBreedListUseCase(
    private val repository: BreedRepository
) {

    operator fun invoke() = repository.getCacheBreedList()
        .flowOn(Dispatchers.IO)
        .map {
            it.filter { breed ->
                breed.isFavorite
            }
        }

}