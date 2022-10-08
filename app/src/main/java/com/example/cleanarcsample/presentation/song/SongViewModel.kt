package com.example.cleanarcsample.presentation.song

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarcsample.domain.song.GetSongUserCase
import com.example.cleanarcsample.utils.UIStatus
import com.example.cleanarcsample.data.songs.model.SongModel
import com.example.cleanarcsample.utils.extensions.launchOnIO
import com.example.cleanarcsample.utils.extensions.launchOnMain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUserCase: GetSongUserCase
) : ViewModel() {

    private val _songList = MutableLiveData<SongModel>()
    val songList: LiveData<SongModel> = _songList

    private val _state = MutableLiveData(UIStatus.LOADING)
    val state: LiveData<UIStatus> get() = _state

    fun getSongs(keyyword : String, offset : Int , limit : Int) {

        viewModelScope.launchOnMain {
            _songList.value = getSongUserCase.invoke(keyyword,offset,limit)
            _state.value = UIStatus.SUCCESS
        }
    }
}