package com.alanturing.cpifp.pokemonroom.data.db

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonDBRepository @Inject constructor(private val pokemonDao:PokemonDao) {

    val allPokemon: Flow<List<PokemonEntity>> = pokemonDao.getAll()

    @WorkerThread
    suspend fun insert(listPokemonEntity: List<PokemonEntity>) {
        pokemonDao.insert(listPokemonEntity)
    }
}

