package com.example.cleanarcsample.presentation.songs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarcsample.R
import com.example.cleanarcsample.domain.songs.usecase.GetSongUserCase
import com.example.cleanarcsample.utils.response.UIStatus
import com.example.cleanarcsample.domain.songs.model.SongModel
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.extensions.launchOnIO
import com.example.cleanarcsample.utils.extensions.string
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUserCase: GetSongUserCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<Resource<SongModel?>> = MutableStateFlow(Resource.Loading(UIStatus.LOADING))
    val uiState: StateFlow<Resource<SongModel?>> get() = _uiState

    fun getSongs(keyword: String, offset: Int, limit: Int): StateFlow<Resource<SongModel?>> {

        viewModelScope.launchOnIO {

            when (val response = getSongUserCase.invoke(keyword, offset, limit)) {

                is Resource.Success -> {
                    _uiState.emit(Resource.Success(response.data, response.state))
                }
                is Resource.Error -> {
                    _uiState.emit(Resource.Error(
                        string(R.string.CheckYourInternetConnection),
                        response.state
                    ))
                }
                is Resource.Loading -> {
                    _uiState.emit(Resource.Loading(UIStatus.LOADING))
                }
            }
        }
        return _uiState

    }
}