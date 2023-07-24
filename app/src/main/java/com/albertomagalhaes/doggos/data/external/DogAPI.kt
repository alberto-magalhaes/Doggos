package com.albertomagalhaes.doggos.data.external

import com.albertomagalhaes.doggos.data.external.dto.BreedImagesDTO
import com.albertomagalhaes.doggos.data.external.dto.BreedListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface DogAPI {

    @GET("breeds/list/all")
    suspend fun fetchBreedList(): BreedListDTO

    @GET("breed/{breedName}/images")
    suspend fun fetchBreedImages(@Path("breedName") breedName: String): BreedImagesDTO

}