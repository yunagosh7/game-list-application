package com.example.gamelist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamelist.model.GameItemListModel
import com.example.gamelist.network.GamesApi
import kotlinx.coroutines.launch

class GamesViewModel : ViewModel() {
    private val _gameList = MutableLiveData<List<GameItemListModel>>()
    val gameList: LiveData<List<GameItemListModel>> = _gameList


    init {
        getGameList()
    }

    fun getGameList() {
        viewModelScope.launch {
            try {
                val result = GamesApi.retrofitService.getAllGames()
                _gameList.postValue(result)
            } catch (e: Exception) {
                Log.d("GamesViewModel", "Error: ${e.message}")
            }
        }
    }
}