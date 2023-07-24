package com.albertomagalhaes.doggos.feature.favoriteBreedList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.domain.usecase.FavoriteBreedListUseCase
import com.albertomagalhaes.doggos.domain.usecase.FavoriteBreedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteBreedListViewModel(
    favoriteBreedListUseCase: FavoriteBreedListUseCase,
    private val favoriteBreedUseCase: FavoriteBreedUseCase
) : ViewModel() {

    private val _favoriteBreedListFlow: MutableStateFlow<List<BreedModel>> = MutableStateFlow(emptyList())
    val favoriteBreedListFlow = _favoriteBreedListFlow.asStateFlow()

    init {
        viewModelScope.launch {
            favoriteBreedListUseCase().collect {
                _favoriteBreedListFlow.emit(it)
            }
        }
    }

    fun favoriteBreed(item: BreedModel) = viewModelScope.launch {
        favoriteBreedUseCase.invoke(item)
    }
}