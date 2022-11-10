package com.example.cleanarcsample.presentation

import com.example.cleanarcsample.domain.songs.model.SongModel
import com.example.cleanarcsample.domain.songs.model.SongModelResult

fun getDummyData() : SongModel {
    val song1 = SongModelResult(
        0,
        "Volkan Konak",
        "",
        "",
        "",
        "",
        "",
        "",
        0,
        "",
        0.0,
        "",
        "",
        "",
        0,
        0,
        true,
        "",
        "",
        "",
        "",
        "",
        0,
        "",
        0,
        "Aleni Aleni",
        0,
        0.0,
        0,
        "",
        "",
    )

    return SongModel(1, arrayListOf(song1))

}