package com.example.cleanarcsample.domain.songs

import com.example.cleanarcsample.domain.songs.model.SongModel
import com.example.cleanarcsample.utils.response.Resource


interface SongRepository {

    suspend fun getSong(keyword : String, offset : Int, limit : Int) : Resource<SongModel>

}