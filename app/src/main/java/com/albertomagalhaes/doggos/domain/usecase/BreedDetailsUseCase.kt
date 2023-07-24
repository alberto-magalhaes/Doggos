package com.albertomagalhaes.doggos.domain.usecase

import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.data.repository.BreedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class BreedDetailsUseCase(
    private val repository: BreedRepository
){
    operator fun invoke(breedId: String) =
        repository.getCacheBreed(breedId)
            .flowOn(Dispatchers.IO)
            .onEach {
                if(it.picturesURL.isNullOrEmpty()){
                    syncBreedImages(it)
                }
            }

    private suspend fun syncBreedImages(breed: BreedModel) {
        repository.fetchBreedImageList(breed.name.lowercase())
            .flowOn(Dispatchers.IO)
            .collect { breedImageList ->
                repository.cacheBreedImageList(breed, breedImageList)
            }
    }

}