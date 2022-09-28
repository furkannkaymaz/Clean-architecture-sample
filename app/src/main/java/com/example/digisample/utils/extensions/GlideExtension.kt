package com.example.digisample.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadImage(url: Any){
    Glide.with(this)
        .load(url)
        .centerCrop()
        .transform(FitCenter(), RoundedCorners(25))
        .into(this)
}