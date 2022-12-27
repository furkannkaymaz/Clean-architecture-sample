package com.example.cleanarcsample.presentation.songs.ui

import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import javax.inject.Inject

class SongUiMapper @Inject constructor() : SongListMapper<SongEntity, SongUiData> {
    override fun map(input: List<SongEntity>): List<SongUiData> {
        return input.map {
            SongUiData(
                it.artistName,
                it.artworkUrl100
            )
        }
    }
}