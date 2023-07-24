package com.albertomagalhaes.doggos.domain.usecase

import com.albertomagalhaes.doggos.data.repository.BreedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class BreedListUseCase(
    private val repository: BreedRepository
) {

    operator fun invoke() = repository.getCacheBreedList()
        .flowOn(Dispatchers.IO)
        .onEach {
            if(it.isEmpty()){
                syncBreedList()
            }
        }

    private suspend fun syncBreedList() {
        repository.fetchBreedList()
            .flowOn(Dispatchers.IO)
            .collect { breedList ->
                repository.cacheBreedList(breedList)
            }
    }

}