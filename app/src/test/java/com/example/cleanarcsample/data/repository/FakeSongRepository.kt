package com.example.cleanarcsample.data.repository

import com.example.cleanarcsample.data.dto.SongModel
import com.example.cleanarcsample.data.songs.repository.SongRepository
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.response.UIStatus

class FakeSongRepository(private var list: SongModel) : SongRepository {

    override suspend fun getSong(keyword: String, offset: Int, limit: Int): Resource<SongModel> {
        return when {
            keyword.length < 15 && limit > 0 && offset < 100 && keyword.length > 3  -> {
                Resource.Success(list, UIStatus.SUCCESS)
            }
            limit == 0 -> {
                Resource.Error("Limit invalid ", UIStatus.ERROR)
            }
            keyword.length > 15 -> {
                Resource.Error("Word limit exceeded ", UIStatus.ERROR)
            }
            offset > 100 -> {
                Resource.Error("Offset limit exceeded ", UIStatus.ERROR)
            }
            keyword.length < 3 -> {
                Resource.Success(SongModel(0, arrayListOf()), UIStatus.LOADING)
            }
            else -> {
                Resource.Success(list, UIStatus.SUCCESS)
            }
        }
    }
}
