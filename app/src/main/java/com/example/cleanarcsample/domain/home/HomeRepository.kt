package com.example.cleanarcsample.domain.home

import com.furkan.tfkbcase.data.model.SongModel


interface SongRepository {

    suspend fun getSong(keyword : String, offset : Int, limit : Int) : SongModel

}