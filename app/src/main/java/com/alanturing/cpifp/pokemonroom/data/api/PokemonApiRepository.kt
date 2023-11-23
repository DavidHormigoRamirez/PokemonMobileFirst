package com.alanturing.cpifp.pokemonroom.data.api

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PokemonApiRepository @Inject constructor(private val service:PokemonService){

    suspend fun getAll():List<PokemonApiModel> {
        val simpleList = service.api.getAll(limit = 150,offset=0)
        return simpleList.results.map {
            pokemonListItem -> service.api.getDetail(pokemonListItem.name).asApiModel()
        }
    }
}