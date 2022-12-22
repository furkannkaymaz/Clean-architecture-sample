package com.example.cleanarcsample.presentation.songs.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cleanarcsample.data.model.SongModelResult
import com.example.cleanarcsample.domain.songs.mapper.SongListEntityMapper
import com.example.cleanarcsample.presentation.FakeGetSongUseCaseImpl
import com.example.cleanarcsample.presentation.FakeSongRepository
import com.example.cleanarcsample.presentation.getDummyData
import com.example.cleanarcsample.utils.extensions.launchOnIO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock

@ExperimentalCoroutinesApi
class SongViewModelTest {

    private lateinit var viewModel: SongViewModel
    private lateinit var userCase: FakeGetSongUseCaseImpl
    private lateinit var repository: FakeSongRepository
    private val songUiMapper = SongUiMapper()
    private val songListEntityMapper = SongListEntityMapper()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        repository = FakeSongRepository(getDummyData())
        userCase = FakeGetSongUseCaseImpl(repository,songListEntityMapper)
        viewModel = SongViewModel(userCase,songUiMapper)
    }

    @Test
    fun `get song list success return true`() = runTest(UnconfinedTestDispatcher()) {
        launchOnIO {
            val data = viewModel.getSongs("123", offset = 5, limit =  5)
            delay(500)
        //    assertTrue(data.value.data?.results?.first()?.artistName != null)
            assertTrue(data.value.data?.first()?.artistName != null)
        }

    }

    @Test
    fun `get song list limit invalid exceeded return False`() = runTest(UnconfinedTestDispatcher()) {
        val data = viewModel.getSongs("Şarkı Listesi", offset = 8, limit = 0)
        delay(600)
        assertFalse(data.value.data != null)
    }

    @Test
    fun `get song list keyword limit exceeded return false`() = runTest(UnconfinedTestDispatcher()) {
        val data = viewModel.getSongs("Çok uzun bir yazı deneme testi", 2, 2)
        delay(600)
        assertFalse(data.value.data != null)
    }
    @Test
    fun `get song list offset limit exceeded return false`() = runTest(UnconfinedTestDispatcher()) {
        val data = viewModel.getSongs("Aa", 455, 2)
        delay(600)
        assertFalse(data.value.data != null)

    }
    @Test
    fun `get song list keyword under 3 letter return empty list`() = runTest(UnconfinedTestDispatcher()) {
        launchOnIO {
            val data = viewModel.getSongs("A", 45, 2)
            delay(600)
            assertEquals(data.value.data, arrayListOf<SongModelResult>())
        }
    }

}