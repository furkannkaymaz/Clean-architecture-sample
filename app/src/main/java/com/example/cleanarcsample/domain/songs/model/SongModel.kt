package com.example.cleanarcsample.domain.songs.model

import com.example.cleanarcsample.data.songs.model.SongModelResult

data class SongModel(
    val resultCount: Int?,
    val results: List<SongModelResult>?
)