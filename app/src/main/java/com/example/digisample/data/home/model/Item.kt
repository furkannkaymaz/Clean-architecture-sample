package com.example.digisample.data.home.model

data class Item(
    val Code: String,
    val Description: String,
    val DisplayName: Any,
    val Items: List<ItemX>,
    val Name: String,
    val SortOrder: Int
)