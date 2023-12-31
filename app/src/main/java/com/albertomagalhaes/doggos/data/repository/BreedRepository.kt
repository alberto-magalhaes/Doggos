package com.albertomagalhaes.doggos.data.repository

import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import kotlinx.coroutines.flow.Flow

interface BreedRepository {

    fun fetchBreedList(): Flow<List<BreedModel>>

    suspend fun cacheBreedList(breedList: List<BreedModel>)

    fun getCacheBreedList(): Flow<List<BreedModel>>

    fun getCacheBreed(breedId: String): Flow<BreedModel>

    suspend fun favoriteBreed(breed: BreedModel)

    fun fetchBreedImageList(breedName: String): Flow<List<String>>

    suspend fun cacheBreedImageList(breedModel: BreedModel, breedImageList: List<String>)

}