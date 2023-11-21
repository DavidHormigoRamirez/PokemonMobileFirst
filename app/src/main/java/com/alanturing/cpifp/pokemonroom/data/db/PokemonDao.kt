package com.alanturing.cpifp.pokemonroom.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(listPokemonEntity: List<PokemonEntity>)
    @Query("SELECT * FROM pokemon")
    fun getAll(): Flow<List<PokemonEntity>>
}