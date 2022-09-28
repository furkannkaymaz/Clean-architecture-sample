package com.example.digisample.data.home.model

data class ItemX(
    val Code: String,
    val Description: String,
    val DisplayName: String,
    val HasTeam: Boolean,
    val Id: String,
    val IsActive: Boolean,
    val Logo: String,
    val MenuItems: List<MenuItem>,
    val MiniPoster: Any,
    val Name: String,
    val Poster: String
)