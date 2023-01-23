package com.example.cleanarcsample.domain.songs.usecase

import com.example.cleanarcsample.data.dto.SongModelResult
import com.example.cleanarcsample.data.songs.repository.SongRepository
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.response.UIStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSongUseCaseImpl @Inject constructor(
    private val songRepository: SongRepository,
    private val mapper: SongListMapper<SongModelResult, SongEntity>
) : GetSongUseCase {

    override fun invoke(
        keyword: String,
        offset: Int,
        limit: Int
    ): Flow<Resource<List<SongEntity>>> = flow {
        emit(Resource.Loading(UIStatus.LOADING))

        when (val response = songRepository.getSong(keyword, offset, limit)) {

            is Resource.Success<*> -> {
                emit(Resource.Success(mapper.map(response.data?.results!!), response.state))
            }
            is Resource.Error -> {
                emit(Resource.Error(response.message, response.state))
            }
            else -> Unit
        }
    }
}
