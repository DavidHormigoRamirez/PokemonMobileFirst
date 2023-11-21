package com.alanturing.cpifp.pokemonroom.ui.list

import com.alanturing.cpifp.pokemonroom.data.repository.Pokemon

data class PokemonListUiState(
    val pokemon:List<Pokemon>,
    val errorMessage:String?=null,
)
