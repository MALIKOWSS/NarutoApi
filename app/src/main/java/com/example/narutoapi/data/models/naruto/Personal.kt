package com.example.narutoapi.data.models.naruto

import com.google.gson.annotations.SerializedName

data class Personal(
    @SerializedName("species")
    val species: String = "",
)