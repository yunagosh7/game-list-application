package com.example.gamelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelist.R
import com.example.gamelist.model.GameDataModel

class GamesAdapter(private val gameList: List<GameDataModel>)
    : RecyclerView.Adapter<GamesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GamesViewHolder(view)
    }

    override fun getItemCount(): Int = gameList.size

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(gameList[position])
    }
}