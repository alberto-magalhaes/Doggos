package com.albertomagalhaes.doggos.feature.breedList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.domain.usecase.BreedListUseCase
import com.albertomagalhaes.doggos.domain.usecase.FavoriteBreedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BreedListViewModel(
    breedListUseCase: BreedListUseCase,
    private val favoriteBreedUseCase: FavoriteBreedUseCase
) : ViewModel() {

    private val _breedListFlow: MutableStateFlow<List<BreedModel>> = MutableStateFlow(emptyList())
    val breedListFlow = _breedListFlow.asStateFlow()

    init {
        viewModelScope.launch {
            breedListUseCase().collect {
                _breedListFlow.emit(it)
            }
        }
    }

    fun favoriteBreed(item: BreedModel) = viewModelScope.launch {
        favoriteBreedUseCase(item)
    }
}