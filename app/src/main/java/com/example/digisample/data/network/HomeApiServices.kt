package com.example.digisample.data.network

import com.example.digisample.data.home.model.CompetitionData
import com.example.digisample.utils.Resource
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */
interface HomeApiServices {

    @POST("/api/content/competitions")
    suspend fun getContentCompetitions() : CompetitionData
}