package com.example.cleanarcsample.domain.songs.usecase

import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.utils.response.Resource
import kotlinx.coroutines.flow.Flow

interface GetSongUseCase {
    suspend fun invoke(keyword : String, offset : Int, limit : Int) : Resource<List<SongEntity>>
}