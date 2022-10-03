package com.example.cleanarcsample.data.home

import com.example.cleanarcsample.data.network.HomeApiServices
import com.example.cleanarcsample.domain.home.HomeRepository
import com.furkan.tfkbcase.data.model.SongModel
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiServices: HomeApiServices
) : HomeRepository {
    override suspend fun getSong(keyword: String, offset: Int, limit: Int): SongModel {
        return apiServices.getData(keyword,offset,limit)
    }


}