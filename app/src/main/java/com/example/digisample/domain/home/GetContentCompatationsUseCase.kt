package com.example.digisample.domain.home

import com.example.digisample.data.home.model.CompetitionData
import com.example.digisample.utils.Resource
import com.example.digisample.utils.UIStatus
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import javax.inject.Inject

class GetContentCompatationsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun invoke(): Resource<CompetitionData>? {
        return try {
            Resource.Success(homeRepository.getContentCompatations())
        }catch (e : HttpException){
            Resource.Error("handle error",null)
        }
    }

}