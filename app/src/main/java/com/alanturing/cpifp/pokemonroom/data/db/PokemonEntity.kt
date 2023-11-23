package com.alanturing.cpifp.pokemonroom.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alanturing.cpifp.pokemonroom.data.repository.Pokemon

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val name:String,
    val id:Int,
    val frontImageUrl:String,
    val favorite:Boolean=false
)

fun List<PokemonEntity>.asPokemon():List<Pokemon> {
    return this.map {
        Pokemon(it.name.replaceFirstChar { c -> c.uppercase() },
                it.id,
                it.frontImageUrl,
                it.favorite)
    }

}
