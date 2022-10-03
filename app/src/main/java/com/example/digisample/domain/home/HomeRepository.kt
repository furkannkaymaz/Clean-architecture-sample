package com.example.digisample.domain.home

import com.furkan.tfkbcase.data.model.SongModel


interface HomeRepository {

    suspend fun getSong(keyword : String, offset : Int, limit : Int) : SongModel

}