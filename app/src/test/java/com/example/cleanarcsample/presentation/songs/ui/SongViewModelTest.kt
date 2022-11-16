package com.example.cleanarcsample.presentation.songs.ui

import com.example.cleanarcsample.domain.songs.model.SongModel
import com.example.cleanarcsample.domain.songs.model.SongModelResult
import com.example.cleanarcsample.domain.songs.usecase.GetSongUserCase
import com.example.cleanarcsample.presentation.FakeSongRepository
import com.example.cleanarcsample.presentation.getDummyData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SongViewModelTest {

    private lateinit var viewModel: SongViewModel
    private lateinit var userCase: GetSongUserCase
    
    @Before
    fun setUp() {
        userCase = GetSongUserCase(FakeSongRepository(getDummyData()))
        viewModel = SongViewModel(userCase)
    }

    @Test
    fun `get song list success return true`() = runBlocking {
        val data = viewModel.getSongs("123", offset = 5, limit =  5)
        delay(500)
        assertTrue(data.value.data?.results?.first()?.artistName != null)
    }

    @Test
    fun `get song list limit invalid exceeded return assertFalse`() = runBlocking {
        val data = viewModel.getSongs("Şarkı Listesi", offset = 8, limit = 0)
        delay(600)
        assertFalse(data.value.data != null)
    }

    @Test
    fun `get song list keyword limit exceeded return false`() = runBlocking {
        val data = viewModel.getSongs("Çok uzun bir yazı deneme testi", 2, 2)
        delay(600)
        assertFalse(data.value.data != null)
    }
    @Test
    fun `get song list offset limit exceeded return false`() = runBlocking {
        val data = viewModel.getSongs("Aa", 455, 2)
        delay(600)
        assertFalse(data.value.data != null)

    }
    @Test
    fun `get song list keyword under 3 letter return empty list`() = runBlocking {
        val data = viewModel.getSongs("A", 45, 2)
        delay(600)
        assertEquals(data.value.data?.results, arrayListOf<SongModelResult>())

    }

}