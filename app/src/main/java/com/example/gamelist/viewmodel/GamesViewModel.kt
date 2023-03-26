package com.example.gamelist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamelist.model.GameDataModel
import com.example.gamelist.network.GamesApi
import kotlinx.coroutines.launch

class GamesViewModel : ViewModel() {
    private val _gameList = MutableLiveData<List<GameDataModel>>()
    val gameList: LiveData<List<GameDataModel>> = _gameList


    init {
        getGameList()
    }

    fun getGameList() {
        viewModelScope.launch {
            try {
                Log.d("GamesViewModel", "Mensaje de prueba")
                val result = GamesApi.retrofitService.getAllGames()
                Log.d("GamesViewModel", "Result: $result")
                _gameList.postValue(result)
            } catch (e: Exception) {
                Log.d("GamesViewModel", "Error: ${e.message}")
            }
        }
    }
}