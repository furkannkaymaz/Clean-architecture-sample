package com.example.cleanarcsample.data.songs.repository

import com.example.cleanarcsample.data.base.BaseRepository
import com.example.cleanarcsample.data.network.SongApiServices
import com.example.cleanarcsample.data.dto.SongModel
import com.example.cleanarcsample.utils.response.Resource
import javax.inject.Inject

class SongRepositoryImp @Inject constructor(
    private val apiServices: SongApiServices
) : BaseRepository(), SongRepository {

    override suspend fun getSong(keyword: String, offset: Int, limit: Int): Resource<SongModel> {
        return safeApiRequest {
            apiServices.getData(keyword,offset,limit)
        }
    }
}