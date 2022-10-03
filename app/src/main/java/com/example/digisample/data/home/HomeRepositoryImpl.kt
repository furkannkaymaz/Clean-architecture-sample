package com.example.digisample.data.home

import com.example.digisample.data.network.HomeApiServices
import com.example.digisample.domain.home.HomeRepository
import com.example.digisample.utils.Resource
import com.furkan.tfkbcase.data.model.SongModel
import javax.inject.Inject

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */

class HomeRepositoryImpl @Inject constructor(
    private val apiServices: HomeApiServices
) : HomeRepository {
    override suspend fun getSong(keyword: String, offset: Int, limit: Int): SongModel {
        return apiServices.getData(keyword,offset,limit)
    }


}