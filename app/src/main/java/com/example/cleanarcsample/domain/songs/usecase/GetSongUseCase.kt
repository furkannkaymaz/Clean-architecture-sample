package com.example.cleanarcsample.domain.songs.usecase

import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.utils.response.Resource

interface GetSongUseCase {
    suspend fun getSong(keyword : String, offset : Int, limit : Int) : Resource<List<SongEntity>>
}