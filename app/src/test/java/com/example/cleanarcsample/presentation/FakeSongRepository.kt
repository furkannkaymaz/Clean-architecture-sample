package com.example.cleanarcsample.presentation

import com.example.cleanarcsample.domain.songs.model.SongModel
import com.example.cleanarcsample.domain.songs.model.SongModelResult
import com.example.cleanarcsample.domain.songs.repository.SongRepository
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.response.UIStatus

class FakeSongRepository(private var list: SongModel) : SongRepository {

    override suspend fun getSong(keyword: String, offset: Int, limit: Int): Resource<SongModel> {
        return if (keyword.length < 15 && limit > 0 && offset < 100) {
            Resource.Success(list, UIStatus.SUCCESS)
        } else if (limit == 0) {
            Resource.Error("Limit invalid ", UIStatus.ERROR)
        } else if (keyword.length > 15) {
            Resource.Error("Word limit exceeded ", UIStatus.ERROR)
        } else if (offset > 100) {
            Resource.Error("Offset limit exceeded ", UIStatus.ERROR)
        } else {
            Resource.Success(list, UIStatus.SUCCESS)
        }
    }
}
