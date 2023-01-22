package com.example.cleanarcsample.domain.songs.mapper

import com.example.cleanarcsample.data.dto.SongModelResult
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.getDummyData
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SongListEntityMapperTest{

    private val songListEntityMapper: SongListEntityMapper = SongListEntityMapper()
    private lateinit var songModelResult: List<SongModelResult>
    private lateinit var songEntity: List<SongEntity>

    @Before
    fun setup(){
        songModelResult = getDummyData().results!!
        songEntity = songListEntityMapper.map(songModelResult)
    }
    @Test
    fun `artistName when songListEntityMapper is same`() {
        assertEquals(songModelResult.first().artistName,songEntity.first().artistName)
    }

    @Test
    fun `artistName when songListEntityMapper is not same`() {
        assertNotEquals(songModelResult.first().artistName,songEntity.first().artworkUrl100)
    }
}