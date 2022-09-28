package com.example.digisample.domain.home

import com.example.digisample.data.home.model.CompetitionData
import com.example.digisample.utils.Resource
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */

interface HomeRepository {

    suspend fun getContentCompatations() : CompetitionData

}