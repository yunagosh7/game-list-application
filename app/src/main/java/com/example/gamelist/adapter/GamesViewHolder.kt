package com.example.gamelist.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelist.R
import com.example.gamelist.databinding.ItemGameBinding
import com.example.gamelist.model.GameDataModel
import com.squareup.picasso.Picasso

class GamesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemGameBinding.bind(view)


    fun bind(gameView: GameDataModel) {

        binding.tvName.text = gameView.name
        binding.tvDesc.text = gameView.desc
        Picasso.get().load(gameView.image).into(binding.ivImage)
    }
}