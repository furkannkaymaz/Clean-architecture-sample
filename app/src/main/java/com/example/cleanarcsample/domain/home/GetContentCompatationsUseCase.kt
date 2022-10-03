package com.example.cleanarcsample.domain.home

import com.furkan.tfkbcase.data.model.SongModel
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