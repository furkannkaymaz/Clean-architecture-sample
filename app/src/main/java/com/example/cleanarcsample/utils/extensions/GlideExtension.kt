package com.example.cleanarcsample.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.cleanarcsample.R

fun ImageView.loadImage(url: String?){
    Glide.with(this)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_baseline_image)
        .error(R.drawable.ic_baseline_error)
        .transform(FitCenter(), RoundedCorners(25))
        .into(this)
}