package com.example.gamelist.model

import com.google.gson.annotations.SerializedName

data class GameDetailModel (
        @SerializedName("title") val name: String,
        @SerializedName("thumbnail") val image: String,
        @SerializedName("genre") val genres: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("screenshots") val screenshots: List<GameScreenshot>
        )

data class GameScreenshot (
    @SerializedName("image") val url: String,
    var isSelected: Boolean = false
        )