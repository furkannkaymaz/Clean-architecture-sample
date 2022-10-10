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
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUserCase: GetSongUserCase
) : ViewModel() {

    private val _songList = MutableLiveData<Resource<SongModel?>>()
    val songList: LiveData<Resource<SongModel?>> = _songList

    fun getSongs(keyyword: String, offset: Int, limit: Int) {

        viewModelScope.launchOnMain {
            val response = getSongUserCase.invoke(keyyword, offset, limit)
            when (response) {
                is Resource.Success -> {
                    _songList.value = Resource.Success(response.data,response.state)
                }
                is Resource.Error -> {
                    _songList.value = Resource.Error("Hata",null,response.state)
                }

            }
        }
    }
}