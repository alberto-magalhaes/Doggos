package com.albertomagalhaes.doggos.data.repository

import com.albertomagalhaes.doggos.data.converter.toInternal
import com.albertomagalhaes.doggos.data.external.DogAPI
import com.albertomagalhaes.doggos.data.external.RetrofitService.getService
import com.albertomagalhaes.doggos.data.internal.dao.BreedDAO
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow

class BreedRepositoryImpl(
    private val breedDAO: BreedDAO
): BreedRepository {

    private val dogAPI = getService<DogAPI>()

    override fun fetchBreedList(): Flow<List<BreedModel>> = flow {
        emit(dogAPI.fetchBreedList().toInternal())
    }

    override suspend fun cacheBreedList(breedList: List<BreedModel>) {
        breedDAO.insertAll(breedList)
    }

    override fun getCacheBreedList() = breedDAO.getAll()

    override suspend fun favoriteBreed(breed: BreedModel) {
        breedDAO.update(breed)
    }

    override fun fetchBreedImageList(breedName: String): Flow<List<String>> = flow {
        emit(dogAPI.fetchBreedImages(breedName))
    }

    override suspend fun cacheBreedImageList(
        breedModel: BreedModel,
        breedImageList: List<String>
    ) {
        breedDAO.insert(breedModel.copy(picturesURL = breedImageList))
    }

}