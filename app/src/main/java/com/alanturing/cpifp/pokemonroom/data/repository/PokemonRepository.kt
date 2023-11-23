package com.alanturing.cpifp.pokemonroom.data.repository


import com.alanturing.cpifp.pokemonroom.data.api.PokemonApiRepository
import com.alanturing.cpifp.pokemonroom.data.api.asEntityModel
import com.alanturing.cpifp.pokemonroom.data.db.PokemonDBRepository
import com.alanturing.cpifp.pokemonroom.data.db.asPokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val dbRepository: PokemonDBRepository,
    private val apiRepository: PokemonApiRepository
) {
    val pokemon: Flow<List<Pokemon>>
        get() {

        val list = dbRepository.allPokemon.map {
            it.asPokemon()
        }
        return list
    }

    suspend fun refreshList() = withContext(Dispatchers.IO){
            val apiPokemon = apiRepository.getAll()
            dbRepository.insert(apiPokemon.asEntityModel())
    }
}