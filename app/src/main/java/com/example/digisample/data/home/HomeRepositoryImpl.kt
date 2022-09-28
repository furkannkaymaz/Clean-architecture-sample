package com.example.digisample.data.home

import com.example.digisample.data.home.model.CompetitionData
import com.example.digisample.data.network.HomeApiServices
import com.example.digisample.domain.home.HomeRepository
import com.example.digisample.utils.Resource
import javax.inject.Inject

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */

class HomeRepositoryImpl @Inject constructor(
    private val apiServices: HomeApiServices
) : HomeRepository {

    override suspend fun getContentCompatations(): CompetitionData {
        return apiServices.getContentCompetitions()
    }

}