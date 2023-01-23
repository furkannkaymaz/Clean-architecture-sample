package com.example.cleanarcsample.domain.songs.usecase

import com.example.cleanarcsample.R
import com.example.cleanarcsample.data.dto.SongModelResult
import com.example.cleanarcsample.data.repository.FakeSongRepository
import com.example.cleanarcsample.data.songs.repository.SongRepository
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import com.example.cleanarcsample.domain.songs.usecase.GetSongUseCase
import com.example.cleanarcsample.utils.extensions.string
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.response.UIStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetSongUseCaseImpl(
    private val fakeSongRepository: FakeSongRepository,
    private val mapper: SongListMapper<SongModelResult, SongEntity>
) : GetSongUseCase {
    override fun invoke(
        keyword: String,
        offset: Int,
        limit: Int
    ): Flow<Resource<List<SongEntity>>> = flow {
        emit(Resource.Loading(UIStatus.LOADING))

        when (val response = fakeSongRepository.getSong(keyword, offset, limit)) {

            is Resource.Success -> {
                emit(Resource.Success(mapper.map(response.data?.results!!), response.state))
            }
            is Resource.Error -> {
                emit(
                    Resource.Error(
                        string(R.string.CheckYourInternetConnection),
                        response.state
                    )
                )
            }
            else -> Unit
        }
    }
}