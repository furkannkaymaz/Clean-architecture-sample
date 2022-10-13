package com.example.cleanarcsample.utils.extensions

import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.example.cleanarcsample.app.di.MyApp

fun string(id: Int): String {
    return MyApp.instance.resources.getString(id)
}

fun color(id: Int): Int {
    return ContextCompat.getColor(MyApp.instance, id)
}