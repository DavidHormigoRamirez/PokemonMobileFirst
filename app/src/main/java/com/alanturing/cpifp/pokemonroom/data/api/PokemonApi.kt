package com.alanturing.cpifp.pokemonroom.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

interface PokemonApi {

    @GET("pokemon")
    suspend fun getAll(@Query("limit") limit:Int=20, @Query("offset") offset:Int=0): PokemonListResponse
    @GET("pokemon/{name}/")
    suspend fun getDetail(@Path("name") name:String): PokemonDetailResponse
}
@Singleton
class PokemonService @Inject constructor() {
private val retrofit = Retrofit.Builder()
    .baseUrl("https://pokeapi.co/api/v2/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val api:PokemonApi = retrofit.create(PokemonApi::class.java)
}