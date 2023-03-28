package com.example.gamelist.adapter

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelist.R
import com.example.gamelist.databinding.ItemScreenshotBinding
import com.example.gamelist.model.GameScreenshot
import com.squareup.picasso.Picasso

class GameDetailScreenshotsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageView = view.findViewById<ImageView>(R.id.iv_screenshot)

    fun bind(screenshot: GameScreenshot) {
        try {

            Log.d("ScreenshotViewHolder", "Prueba desde el viewholder")
            Picasso.get().load(screenshot.url).into(imageView)
        } catch (e: Exception) {
            Log.d("ScreenshotViewHolder", "Error: ${e.message}")
        }
    }
}