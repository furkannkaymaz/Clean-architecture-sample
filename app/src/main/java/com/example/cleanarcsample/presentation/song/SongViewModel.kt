package com.example.cleanarcsample.presentation.song

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarcsample.domain.song.GetSongUserCase
import com.example.cleanarcsample.utils.UIStatus
import com.example.cleanarcsample.data.songs.model.SongModel
import com.example.cleanarcsample.utils.Resource
import com.example.cleanarcsample.utils.extensions.launchOnIO
import com.example.cleanarcsample.utils.extensions.launchOnMain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUserCase: GetSongUserCase
) : ViewModel() {

    fun getSongs(keyword: String, offset: Int, limit: Int) : MutableStateFlow<Resource<SongModel?>> {

        val stateFlow : MutableStateFlow<Resource<SongModel?>> = MutableStateFlow(Resource.Loading())

        viewModelScope.launchOnIO {
            val response = getSongUserCase.invoke(keyword, offset, limit)
            when (response) {
                is Resource.Success -> {
                    stateFlow.emit(Resource.Success(response.data,response.state))
                }
                is Resource.Error -> {
                    stateFlow.emit(Resource.Error("Hata",null,response.state))
                }
            }
        }
        return stateFlow

    }
}