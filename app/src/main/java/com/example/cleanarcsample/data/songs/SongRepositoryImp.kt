package com.example.cleanarcsample.data.songs

import com.example.cleanarcsample.data.network.SongApiServices
import com.example.cleanarcsample.domain.song.SongRepository
import com.example.cleanarcsample.data.songs.model.SongModel
import javax.inject.Inject

class SongRepositoryImp @Inject constructor(
    private val apiServices: SongApiServices
) : SongRepository {
    override suspend fun getSong(keyword: String, offset: Int, limit: Int): SongModel {
        return apiServices.getData(keyword,offset,limit)
    }
}