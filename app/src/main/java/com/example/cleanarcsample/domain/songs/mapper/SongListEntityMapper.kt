package com.example.cleanarcsample.domain.songs.mapper

import com.example.cleanarcsample.data.model.SongModel
import com.example.cleanarcsample.data.model.SongModelResult
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SongListEntityMapper @Inject constructor() : SongListMapper<SongModelResult, SongEntity> {
    override fun map(input: List<SongModelResult>): List<SongEntity> {
        return input.map {
            SongEntity(
                it.artistName,
                it.artworkUrl100
            )
        }
    }
}