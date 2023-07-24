package com.albertomagalhaes.doggos.data.converter

import com.albertomagalhaes.doggos.commons.extensions.capitalizeFirst
import com.albertomagalhaes.doggos.data.external.dto.BreedImagesDTO
import com.albertomagalhaes.doggos.data.external.dto.BreedListDTO
import com.albertomagalhaes.doggos.data.internal.model.BreedModel

fun BreedListDTO.toInternal(): List<BreedModel> = message.map { map ->
    BreedModel(
        name = map.key.capitalizeFirst(),
        subBreads = map.value.map { it.capitalizeFirst() },
        picturesURL = listOf()
    )
}

fun BreedImagesDTO.toInternal(): List<String> = message