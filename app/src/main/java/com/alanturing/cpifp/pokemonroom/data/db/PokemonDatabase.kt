package com.alanturing.cpifp.pokemonroom.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokemonDatabase(): RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object {
        @Volatile
        private var INSTANCE: PokemonDatabase? = null

        fun getInstance(context: Context): PokemonDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): PokemonDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                PokemonDatabase::class.java,
                "pokemon_db"
            ).build()
        }
    }
}
