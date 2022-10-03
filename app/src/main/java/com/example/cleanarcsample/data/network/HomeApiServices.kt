package com.example.cleanarcsample.data.network

import com.furkan.tfkbcase.data.model.SongModel
import retrofit2.http.GET
import retrofit2.http.Query


interface HomeApiServices {

    @GET("search")
    suspend fun getData(@Query("term") keyword: String,
                        @Query("offset") offset: Int,
                        @Query("limit") limit: Int): SongModel

}