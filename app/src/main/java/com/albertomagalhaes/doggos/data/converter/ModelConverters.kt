package com.albertomagalhaes.doggos.data.converter

import com.albertomagalhaes.doggos.data.external.dto.BreedImagesDTO
import com.albertomagalhaes.doggos.data.external.dto.BreedListDTO
import com.albertomagalhaes.doggos.data.internal.model.BreedModel

fun BreedListDTO.toInternal(): List<BreedModel> = message.map {
    BreedModel(name = it.key, subBreads = it.value, picturesURL = listOf())
}

fun BreedImagesDTO.toInternal(): List<String> = message
