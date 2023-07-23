package com.albertomagalhaes.doggos.feature.breedDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.domain.usecase.BreedDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BreedDetailsViewModel(
    private val breedDetailsUseCase: BreedDetailsUseCase,
) : ViewModel() {

    private val _breedFlow: MutableStateFlow<BreedModel?> = MutableStateFlow(null)
    val breedFlow = _breedFlow.asStateFlow()

    fun getBreed(breedId: String) {
        viewModelScope.launch {
            breedDetailsUseCase(breedId).collect {
                _breedFlow.emit(it)
            }
        }
    }

}