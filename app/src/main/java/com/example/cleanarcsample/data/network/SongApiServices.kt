package com.example.cleanarcsample.data.network

import com.example.cleanarcsample.data.dto.SongModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SongApiServices {

    @GET("search")
    suspend fun getData(@Query("term") keyword: String,
                        @Query("offset") offset: Int,
                        @Query("limit") limit: Int): SongModel
}