package com.alanturing.cpifp.pokemonroom.data.api

import com.alanturing.cpifp.pokemonroom.data.db.PokemonEntity
import com.google.gson.annotations.SerializedName

data class PokemonApiModel(
    val name:String,
    val id:Int,
    val frontImageUrl:String
)

data class PokemonListResponse(
    val count:Int,
    val results: List<PokemonListItemResponse>
)

data class PokemonListItemResponse(
    val name:String
)

data class PokemonDetailResponse(
    val name:String,
    val id:Int,
    val sprites: PokemonSpritesResponse
){
    fun asApiModel():PokemonApiModel {
        return PokemonApiModel(
            name,
            id,
            sprites.frontDefault
        )
    }
}

data class PokemonSpritesResponse(
    @SerializedName("front_default")
    val frontDefault:String
)

fun List<PokemonApiModel>.asEntityModel(): List<PokemonEntity> {
    return this.map {
        PokemonEntity(
            it.name,
            it.id,
            it.frontImageUrl
        )
    }
}
