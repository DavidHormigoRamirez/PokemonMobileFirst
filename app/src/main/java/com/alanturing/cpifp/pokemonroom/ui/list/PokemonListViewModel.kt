package com.alanturing.cpifp.pokemonroom.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.cpifp.pokemonroom.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {

    private val _uiState = MutableStateFlow(PokemonListUiState(listOf()))
    val uiState: StateFlow<PokemonListUiState>
        get()=_uiState.asStateFlow()
    init {

        viewModelScope.launch {
            try {
                repository.refreshList()
            }
            catch (e:IOException) {
                _uiState.value = _uiState.value.copy(errorMessage = e.message!!)
            }
        }

        viewModelScope.launch {
            repository.pokemon.collect {
                _uiState.value = PokemonListUiState(it)
            }
        }

    }
}