package com.example.gamelist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamelist.adapter.GamesAdapter
import com.example.gamelist.adapter.OnItemsClickListeners
import com.example.gamelist.databinding.ActivityMainBinding
import com.example.gamelist.model.GameDataModel
import com.example.gamelist.viewmodel.GamesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GamesViewModel
    private lateinit var gamesAdapter: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GamesViewModel::class.java)


        initUI()

    }

    private fun initUI() {
        viewModel.gameList.observe(this, Observer {gameList ->
            gamesAdapter = GamesAdapter(gameList, object: OnItemsClickListeners {
                override fun onItemSelected(id: String) {
                    navigateToDetail(id)
                }

                override fun addItem(gameItem: GameDataModel) {
                    addGame(gameItem)
                }
            })

            binding.rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvGames.adapter = gamesAdapter
        })
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, GameDetailActivity::class.java)
        intent.putExtra(GameDetailActivity.EXTRA_ID, id)
        startActivity(intent)
    }

    private fun addGame(gameItem: GameDataModel) {
        Toast.makeText(this, "Añadir funcionalidad, ${gameItem.name}", Toast.LENGTH_SHORT).show()
    }


}