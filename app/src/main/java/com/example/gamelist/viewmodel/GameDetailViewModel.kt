package com.example.gamelist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamelist.model.GameDetailModel
import com.example.gamelist.network.GamesApi
import kotlinx.coroutines.launch

class GameDetailViewModel : ViewModel() {
    private var _gameInfo = MutableLiveData<GameDetailModel>()
    var gameInfo: LiveData<GameDetailModel> = _gameInfo



    fun getGameInfo(id: String) {
        viewModelScope.launch {
            try {
                val result = GamesApi.retrofitService.getOneName(id)
                _gameInfo.postValue(result)
            } catch (e: Exception) {
                Log.d("GameDetailViewModel", "Error: ${e.message}")
            }

        }
    }



}