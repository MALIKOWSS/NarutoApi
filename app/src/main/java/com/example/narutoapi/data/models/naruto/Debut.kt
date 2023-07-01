package com.example.narutoapi.data.models.naruto

import com.google.gson.annotations.SerializedName

data class Debut(
    @SerializedName("appearsIn")
    val appearsIn: String = "",
    @SerializedName("movie")
    val movie: String = "",
    @SerializedName("novel")
    val novel: String = "",
)