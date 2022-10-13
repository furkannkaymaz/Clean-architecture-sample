package com.example.cleanarcsample.utils.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

fun <T>getDiffUtilCallBack() : DiffUtil.ItemCallback<T>{
    return object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }
}
