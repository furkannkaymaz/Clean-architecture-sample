package com.example.cleanarcsample.presentation.songs.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarcsample.R
import com.example.cleanarcsample.utils.response.UIStatus
import com.example.cleanarcsample.data.model.SongModel
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import com.example.cleanarcsample.domain.songs.usecase.GetSongUserCaseImpl
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.extensions.launchOnIO
import com.example.cleanarcsample.utils.extensions.string
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUserCase: GetSongUserCaseImpl,
    private val mapper: SongListMapper<SongEntity, SongUiData>
) : ViewModel() {

    private val _uiState: MutableStateFlow<Resource<List<SongUiData?>>> = MutableStateFlow(Resource.Loading(UIStatus.LOADING))

    fun getSongs(keyword: String, offset: Int, limit: Int): StateFlow<Resource<List<SongUiData?>>> {

        viewModelScope.launchOnIO {
            when (val response = getSongUserCase.getSong(keyword, offset, limit)) {

                is Resource.Success<*> -> {
                    _uiState.emit(Resource.Success(mapper.map(response.data!!), response.state))
                }
                is Resource.Error<*> -> {
                    _uiState.emit(
                        Resource.Error(
                            string(R.string.CheckYourInternetConnection),
                            response.state
                        )
                    )
                }
                is Resource.Loading<*> -> {
                    _uiState.emit(Resource.Loading(UIStatus.LOADING))
                }
            }
        }
        return _uiState
    }
}