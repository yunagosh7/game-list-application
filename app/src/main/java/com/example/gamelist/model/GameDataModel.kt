package com.example.gamelist.model

import com.google.gson.annotations.SerializedName

data class GameDataModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val name: String,
    @SerializedName("thumbnail") val image: String,
    @SerializedName("short_description") val desc: String,
    @SerializedName("platform") val platform: String

)
