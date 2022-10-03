package com.example.digisample.data.network

import com.furkan.tfkbcase.data.model.SongModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */
interface HomeApiServices {

    @GET("search")
    suspend fun getData(@Query("term") keyword: String,
                        @Query("offset") offset: Int,
                        @Query("limit") limit: Int): SongModel

}