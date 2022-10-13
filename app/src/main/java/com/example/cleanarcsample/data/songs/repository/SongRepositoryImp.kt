package com.example.cleanarcsample.data.songs.repository

import com.example.cleanarcsample.data.base.BaseRepository
import com.example.cleanarcsample.data.network.ApiServices
import com.example.cleanarcsample.domain.song.SongRepository
import com.example.cleanarcsample.data.songs.model.SongModel
import com.example.cleanarcsample.utils.response.Resource
import javax.inject.Inject

class SongRepositoryImp @Inject constructor(
    private val apiServices: ApiServices
) : BaseRepository(),SongRepository {

    override suspend fun getSong(keyword: String, offset: Int, limit: Int): Resource<SongModel> {
        return safeApiRequest {
            apiServices.getData(keyword,offset,limit)
        }
    }
}