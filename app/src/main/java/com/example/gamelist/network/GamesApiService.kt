package com.example.gamelist.network

import com.example.gamelist.model.GameDetailModel
import com.example.gamelist.model.GameItemListModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.freetogame.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GamesApiService {
    @GET("/api/games")
    suspend fun getAllGames(): List<GameItemListModel>

    @GET("/api/game")
    suspend fun getOneName(@Query("id") id: String): GameDetailModel

}

// Singleton de retrofit
object GamesApi {
    val retrofitService: GamesApiService by lazy {
        retrofit.create(GamesApiService::class.java)
    }
}