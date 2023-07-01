package com.example.narutoapi.data.models.naruto

import com.google.gson.annotations.SerializedName

data class CharactersItem(
    @SerializedName("debut")
    val debut: Debut,
    @SerializedName("images")
    val images: List<String>?,
    @SerializedName("uniqueTraits")
    val uniqueTraits: List<String>?,
    @SerializedName("jutsu")
    val jutsu: List<String>?,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("personal")
    val personal: Personal,
    @SerializedName("id")
    val id: Int = 0,
)