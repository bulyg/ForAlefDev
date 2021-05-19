package ru.bulyg.foralefdev.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadPictures(url: String, view: ImageView) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}