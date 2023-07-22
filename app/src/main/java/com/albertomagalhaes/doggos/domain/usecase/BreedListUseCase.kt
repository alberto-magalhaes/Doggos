package com.albertomagalhaes.doggos.domain.usecase

import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.data.repository.BreedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.stateIn
import kotlin.coroutines.coroutineContext

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