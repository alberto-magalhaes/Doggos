package com.albertomagalhaes.doggos.domain.usecase

import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.data.repository.BreedRepository

class FavoriteBreedUseCase(
    private val repository: BreedRepository
){
    suspend operator fun invoke(breed: BreedModel) = repository.favoriteBreed(breed)
}