package com.example.cleanarcsample.presentation.song

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarcsample.domain.home.GetSongUserCase
import com.example.cleanarcsample.utils.UIStatus
import com.furkan.tfkbcase.data.model.SongModel
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

        viewModelScope.launch {
       // when (val response = getContentCompatationsUseCase.invoke()) {
       //     is Resource.Success -> {
       //         _compatationList.value = response.data!!
       //         _state.value = UIStatus.SUCCESS
       //     }
       //     is Resource.Error -> {
       //         _state.value = UIStatus.ERROR
       //     }
       //     else -> {
       //         _state.value = UIStatus.ERROR
       //     }
       // }
            _songList.value = getSongUserCase.invoke(keyyword,offset,limit)
            Log.d("deneme",_songList.value?.results.toString())



        }
    }
}