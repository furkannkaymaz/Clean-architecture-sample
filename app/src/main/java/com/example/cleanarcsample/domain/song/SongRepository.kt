package com.example.cleanarcsample.domain.song

import com.example.cleanarcsample.data.songs.model.SongModel
import com.example.cleanarcsample.utils.response.Resource


interface SongRepository {

    suspend fun getSong(keyword : String, offset : Int, limit : Int) : Resource<SongModel>

}