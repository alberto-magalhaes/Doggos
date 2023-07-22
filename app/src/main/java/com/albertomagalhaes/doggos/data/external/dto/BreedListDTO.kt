package com.albertomagalhaes.doggos.data.external.dto

data class BreedListDTO (
    val message: Map<String, List<String>>,
    val status: String,
    val code: Int
)