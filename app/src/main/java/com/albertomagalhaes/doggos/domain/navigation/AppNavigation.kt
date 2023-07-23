package com.albertomagalhaes.doggos.domain.navigation

import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import com.albertomagalhaes.doggos.data.internal.model.BreedModel

fun NavController.navigateToDetails(breed: BreedModel){
    navigate(
        NavDeepLinkRequest.Builder.fromUri("android-app://com.albertomagalhaes.doggos.breed/${breed.id}".toUri()).build()
    )
}