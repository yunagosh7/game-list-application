package com.example.gamelist.adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelist.R
import com.example.gamelist.model.GameScreenshot

var itemSelected = 0

class GameDetailScreenshotsAdapter(
    private var screenshots: List<GameScreenshot> = emptyList(),
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<GameDetailScreenshotsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GameDetailScreenshotsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_screenshot, parent, false)
        return GameDetailScreenshotsViewHolder(view)
    }

    override fun getItemCount() = screenshots.size

    override fun onBindViewHolder(holder: GameDetailScreenshotsViewHolder, position: Int) {
        holder.bind(screenshots[position], onItemSelected)
    }
}