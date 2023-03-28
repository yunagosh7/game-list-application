package com.example.gamelist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamelist.R
import com.example.gamelist.adapter.GameDetailScreenshotsAdapter
import com.example.gamelist.adapter.GameDetailScreenshotsViewHolder
import com.example.gamelist.databinding.ActivityGameDetailBinding
import com.example.gamelist.model.GameDetailModel
import com.example.gamelist.network.GamesApi
import com.example.gamelist.viewmodel.GameDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class GameDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameDetailBinding
    private lateinit var adapter: GameDetailScreenshotsAdapter
    private lateinit var viewModel: GameDetailViewModel

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GameDetailViewModel::class.java)
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()

        getGameInfo(id)

        viewModel.gameInfo.observe(this, Observer {
            printUI(it)
        })
    }

    private fun printUI(gameDetails: GameDetailModel) {
        Picasso.get().load(gameDetails.image).into(binding.ivGameImage)
        binding.tvGameName.text = gameDetails.name
        binding.tvGameGenres.text = gameDetails.genres
        binding.tvReleasedDate.text = gameDetails.releaseDate
        binding.tvScreenshotsName.text = getString(R.string.screenshots_name, gameDetails.name)
        adapter = GameDetailScreenshotsAdapter(gameDetails.screenshots)
        binding.rvScreenshots.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvScreenshots.adapter = adapter

    }

    private fun getGameInfo(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getGameInfo(id)
        }
    }



}