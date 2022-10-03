package com.example.digisample.domain.home

import com.example.digisample.utils.Resource
import com.example.digisample.utils.UIStatus
import com.furkan.tfkbcase.data.model.SongModel
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import javax.inject.Inject

class GetContentCompatationsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun invoke(keyword : String, offset : Int, limit : Int): SongModel? {
        return try {
            homeRepository.getSong(keyword,limit,offset)
        }catch (e : HttpException){
            null
        }
    }


}