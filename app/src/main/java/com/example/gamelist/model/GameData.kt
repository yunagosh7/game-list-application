package com.example.gamelist.model

import com.google.gson.annotations.SerializedName

data class GameData(
    @SerializedName("title") val name: String,
    @SerializedName("thumbnail") val image: String,
    @SerializedName("short_description") val desc: String,

)
