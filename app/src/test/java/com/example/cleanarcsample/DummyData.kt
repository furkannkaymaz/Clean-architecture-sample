package com.example.cleanarcsample

import com.example.cleanarcsample.data.dto.SongModel
import com.example.cleanarcsample.data.dto.SongModelResult
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.presentation.songs.ui.SongUiData

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

fun getDummyDataForEntity() : List<SongEntity> {
    val song = SongEntity(
        "Volkan Konak",
        "www/volkankonak",
    )
    return listOf(song)
}

fun getDummyDataForUi() : List<SongUiData> {
    val song = SongUiData(
        "Volkan Konak",
        "www/volkan Konak",
    )
    return listOf(song)
}

