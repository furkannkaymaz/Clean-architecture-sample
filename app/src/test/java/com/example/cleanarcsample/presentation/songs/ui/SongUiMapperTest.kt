package com.example.cleanarcsample.presentation.songs.ui

import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.getDummyDataForEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SongUiMapperTest{

    private val songListEntityMapper: SongUiMapper = SongUiMapper()
    private lateinit var songEntity: List<SongEntity>
    private lateinit var songUiData:  List<SongUiData>

    @Before
    fun setup(){
        songEntity = getDummyDataForEntity()
        songUiData = songListEntityMapper.map(songEntity)
    }

    @Test
    fun `artistName when SongUiMapper is same`() {
        assertEquals(songEntity.first().artistName,songEntity.first().artistName)
    }

    @Test
    fun `artistName when SongUiMapper is not same`() {
        assertNotEquals(songEntity.first().artistName,songEntity.first().artworkUrl100)
    }
}