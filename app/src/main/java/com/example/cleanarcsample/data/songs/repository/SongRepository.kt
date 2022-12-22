package com.example.cleanarcsample.data.songs.repository

import com.example.cleanarcsample.data.model.SongModel
import com.example.cleanarcsample.utils.response.Resource

interface SongRepository {
    suspend fun getSong(keyword : String, offset : Int, limit : Int) : Resource<SongModel>
}