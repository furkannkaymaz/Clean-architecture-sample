package com.example.cleanarcsample.presentation

import com.example.cleanarcsample.data.model.SongModelResult
import com.example.cleanarcsample.data.songs.repository.SongRepository
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import com.example.cleanarcsample.domain.songs.usecase.GetSongUseCase
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.response.UIStatus

class FakeGetSongUseCaseImpl(
    private val songRepository: SongRepository,
    private val mapper: SongListMapper<SongModelResult, SongEntity>
) : GetSongUseCase {
    override suspend fun invoke(
        keyword: String,
        offset: Int,
        limit: Int
    ): Resource<List<SongEntity>> {
        return Resource.Success(
            mapper.map(
                songRepository.getSong(
                    keyword,
                    offset,
                    limit
                ).data?.results!!
            ), UIStatus.SUCCESS
        )
    }
}