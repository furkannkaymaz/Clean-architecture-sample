package com.example.cleanarcsample.domain.song

import com.example.cleanarcsample.data.songs.model.SongModel
import com.example.cleanarcsample.utils.response.Resource
import javax.inject.Inject

class GetSongUserCase @Inject constructor(
    private val songRepository: SongRepository
) {
    suspend fun invoke(keyword: String, offset: Int, limit: Int): Resource<SongModel> {

        return songRepository.getSong(keyword, limit, offset)

    }
}