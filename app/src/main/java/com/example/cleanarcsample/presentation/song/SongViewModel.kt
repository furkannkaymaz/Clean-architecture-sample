package com.example.cleanarcsample.presentation.song

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarcsample.domain.song.GetSongUserCase
import com.example.cleanarcsample.utils.response.UIStatus
import com.example.cleanarcsample.data.songs.model.SongModel
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.extensions.launchOnIO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUserCase: GetSongUserCase
) : ViewModel() {

    fun getSongs(keyword: String, offset: Int, limit: Int): MutableStateFlow<Resource<SongModel?>> {

        val _uiState: MutableStateFlow<Resource<SongModel?>> =
            MutableStateFlow(Resource.Loading(UIStatus.LOADING))

        viewModelScope.launchOnIO {

            val response = getSongUserCase.invoke(keyword, offset, limit)
            when (response) {

                is Resource.Success -> {
                    _uiState.emit(Resource.Success(response.data, response.state))
                }
                is Resource.Error -> {
                    _uiState.emit(Resource.Error("Hata", null, response.state))
                }
            }
        }
        return _uiState

    }
}