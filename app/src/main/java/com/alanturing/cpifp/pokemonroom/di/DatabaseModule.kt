package com.alanturing.cpifp.pokemonroom.di

import android.content.Context
import com.alanturing.cpifp.pokemonroom.data.db.PokemonDao
import com.alanturing.cpifp.pokemonroom.data.db.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return PokemonDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun providePokemonDao(database: PokemonDatabase): PokemonDao {
        return database.pokemonDao()
    }

}