package com.example.cleanarcsample.domain.songs.usecase

import com.example.cleanarcsample.domain.songs.repository.SongRepository
import com.example.cleanarcsample.domain.songs.model.SongModel
import com.example.cleanarcsample.utils.response.Resource
import javax.inject.Inject

class GetSongUserCase @Inject constructor(
    private val songRepository: SongRepository
) {
    suspend operator fun invoke(keyword: String, offset: Int, limit: Int): Resource<SongModel> {
        return songRepository.getSong(keyword, offset,limit)
    }
}