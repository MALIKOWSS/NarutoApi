package com.example.narutoapi.data.models.naruto

import com.google.gson.annotations.SerializedName

data class NarutoResponse<T>(
    @SerializedName("totalCharacters")
    val totalCharacters: Int = 0,
    @SerializedName("characters")
    val characters: List<T>?,
    @SerializedName("pageSize")
    val pageSize: Int = 0,
    @SerializedName("currentPage")
    val currentPage: Int = 0,
)