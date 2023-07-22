package com.albertomagalhaes.doggos.commons

import com.albertomagalhaes.doggos.data.internal.AppDatabase
import com.albertomagalhaes.doggos.data.repository.BreedRepository
import com.albertomagalhaes.doggos.data.repository.BreedRepositoryImpl
import com.albertomagalhaes.doggos.domain.usecase.BreedListUseCase
import com.albertomagalhaes.doggos.domain.usecase.FavoriteBreedListUseCase
import com.albertomagalhaes.doggos.domain.usecase.FavoriteBreedUseCase
import com.albertomagalhaes.doggos.feature.breedDetails.BreedDetailsViewModel
import com.albertomagalhaes.doggos.feature.breedList.BreedListViewModel
import com.albertomagalhaes.doggos.feature.favoriteBreedList.FavoriteBreedListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        BreedListViewModel(get(), get())
    }
    viewModel {
        FavoriteBreedListViewModel(get(), get())
    }
    viewModel { BreedDetailsViewModel() }
}

val useCaseModule = module {
    single { BreedListUseCase(get()) }
    single { FavoriteBreedUseCase(get()) }
    single { FavoriteBreedListUseCase(get()) }
}

val repositoryModule = module {
    single<BreedRepository> { BreedRepositoryImpl(get()) }
}

val daoModule = module {
    single { AppDatabase.getInstance(androidContext()).breedDAO }
}