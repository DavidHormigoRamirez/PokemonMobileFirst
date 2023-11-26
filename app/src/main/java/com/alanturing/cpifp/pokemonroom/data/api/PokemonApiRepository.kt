package com.alanturing.cpifp.pokemonroom.data.api

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PokemonApiRepository @Inject constructor(private val service:PokemonService){
    // TODO cambiar el límite
    suspend fun getAll():List<PokemonApiModel> {

        val simpleList = service.api.getAll(300,0)
        val pokemonApiModel = simpleList.results.map {
            pokemonListItem -> service.api.getDetail(pokemonListItem.name).asApiModel()
        }
        return pokemonApiModel
    }
}