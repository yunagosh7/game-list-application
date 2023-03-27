package com.example.gamelist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamelist.R

class GameDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detail)
    }
}