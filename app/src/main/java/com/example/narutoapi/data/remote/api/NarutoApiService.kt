package com.example.narutoapi.data.remote.api

import com.example.narutoapi.data.models.naruto.CharactersItem
import com.example.narutoapi.data.models.naruto.NarutoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NarutoApiService {

    @GET("character")
    suspend fun fetchCharacter(): NarutoResponse<CharactersItem>

    @GET("character/{id}")
    suspend fun fetchCharacterSingle(
        @Path("id") id: Int
    ): CharactersItem
}