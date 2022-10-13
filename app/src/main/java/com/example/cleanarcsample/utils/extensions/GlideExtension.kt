package com.example.cleanarcsample.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadImage(url: String?){
    Glide.with(this)
        .load(url)
        .centerCrop()
        .transform(FitCenter(), RoundedCorners(25))
        .into(this)
}