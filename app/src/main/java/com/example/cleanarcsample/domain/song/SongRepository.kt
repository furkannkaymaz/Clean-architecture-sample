package com.example.cleanarcsample.domain.song

import com.example.cleanarcsample.data.songs.model.SongModel


interface SongRepository {

    suspend fun getSong(keyword : String, offset : Int, limit : Int) : SongModel

}