package com.example.gamelist.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelist.R
import com.example.gamelist.model.GameScreenshot
import com.squareup.picasso.Picasso

class GameDetailScreenshotsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageView = view.findViewById<ImageView>(R.id.iv_screenshot)

    fun bind(screenshot: GameScreenshot, onItemSelected:(String) -> Unit) {
        Picasso.get().load(screenshot.url).into(imageView)



        imageView.setOnClickListener {
            onItemSelected(screenshot.url)
        }




    }
}