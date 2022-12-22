package com.example.cleanarcsample.domain.songs.usecase

import com.example.cleanarcsample.R
import com.example.cleanarcsample.data.model.SongModel
import com.example.cleanarcsample.data.model.SongModelResult
import com.example.cleanarcsample.data.songs.repository.SongRepository
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import com.example.cleanarcsample.utils.extensions.string
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.response.UIStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSongUserCaseImpl @Inject constructor(
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


/*class GetSongUserCaseImpl @Inject constructor(
    private val songRepository: SongRepository,
    private val mapper: SongListMapper<SongModelResult, SongEntity>
) : GetSongUseCase {

    override suspend fun invoke(
        keyword: String,
        offset: Int,
        limit: Int
    ): Flow<Resource<List<SongEntity>>> = flow {
        emit(Resource.Loading(UIStatus.LOADING))
        when (val response = songRepository.getSong(keyword, offset, limit).data?.results!!) {

            is Resource.Success<*> -> {
                emit(Resource.Success(mapper.map(response), response.state))
            }
            is Resource.Error<*> -> {
                emit(
                    Resource.Error(
                        string(R.string.CheckYourInternetConnection),
                        response.state
                    )
                )
            }
        }
    }
}*/
