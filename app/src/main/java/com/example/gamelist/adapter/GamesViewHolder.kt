package com.example.gamelist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelist.R
import com.example.gamelist.databinding.ItemGameBinding
import com.example.gamelist.model.GameItemListModel
import com.squareup.picasso.Picasso

class GamesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemGameBinding.bind(view)


    fun bind(gameItem: GameItemListModel, listeners: OnItemsClickListeners ) {

        binding.tvName.text = gameItem.name
        binding.tvDesc.text = gameItem.desc
        Picasso.get().load(gameItem.image).into(binding.ivImage)

        val icon = if(gameItem.platform == "PC (Windows)") {
            R.drawable.ic_windows
        } else {
            R.drawable.ic_web
        }

        binding.ivPlatform.setImageResource(icon)
        binding.container.setOnClickListener {
            listeners.onItemSelected(gameItem.id.toString())
        }

        binding.ivAdd.setOnClickListener {
            listeners.addItem(gameItem)
        }
    }
}