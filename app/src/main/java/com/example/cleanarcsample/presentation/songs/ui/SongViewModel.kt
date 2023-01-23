package com.example.cleanarcsample.presentation.songs.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarcsample.utils.response.UIStatus
import com.example.cleanarcsample.domain.songs.entity.SongEntity
import com.example.cleanarcsample.domain.songs.mapper.SongListMapper
import com.example.cleanarcsample.domain.songs.usecase.GetSongUseCase
import com.example.cleanarcsample.utils.response.Resource
import com.example.cleanarcsample.utils.extensions.launchOnIO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUseCase: GetSongUseCase,
    private val mapper: SongListMapper<SongEntity, SongUiData>
) : ViewModel() {

    private val _uiState: MutableStateFlow<Resource<List<SongUiData>>> = MutableStateFlow(Resource.Loading(UIStatus.LOADING))

    fun getSongs(keyword: String, offset: Int, limit: Int): StateFlow<Resource<List<SongUiData>>> {

        viewModelScope.launchOnIO {
            getSongUseCase.invoke(keyword,offset,limit).collectLatest {
                when (it) {
                    is Resource.Success -> {
                        _uiState.emit(Resource.Success(mapper.map(it.data!!), it.state))
                    }
                    is Resource.Error -> {
                        _uiState.emit(
                            Resource.Error(
                                it.message,
                                it.state
                            )
                        )
                    }
                    else -> Unit
                }
            }
        }
        return _uiState
    }
}