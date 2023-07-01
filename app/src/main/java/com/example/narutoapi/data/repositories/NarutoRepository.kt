package com.example.narutoapi.data.repositories

import com.example.narutoapi.base.BaseRepository
import com.example.narutoapi.data.remote.api.NarutoApiService
import javax.inject.Inject

class NarutoRepository @Inject constructor(private val characterApi: NarutoApiService) : BaseRepository() {

    fun fetchCharacter() = doRequest {
        characterApi.fetchCharacter()
    }

    fun fetchCharacterSingle(id: Int) = doRequest {
        characterApi.fetchCharacterSingle(id)
    }
}