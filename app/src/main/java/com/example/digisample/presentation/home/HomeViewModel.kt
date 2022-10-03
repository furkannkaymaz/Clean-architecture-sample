package com.example.digisample.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.digisample.domain.home.GetContentCompatationsUseCase
import com.example.digisample.utils.UIStatus
import com.furkan.tfkbcase.data.model.SongModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getContentCompatationsUseCase: GetContentCompatationsUseCase
) : ViewModel() {

    private val _compatationList = MutableLiveData<SongModel>()
    val compatationList: LiveData<SongModel> = _compatationList

    private val _state = MutableLiveData(UIStatus.LOADING)
    val state: LiveData<UIStatus> get() = _state

    fun getCompatations(keyyword : String, offset : Int , limit : Int) {

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
                _compatationList.value = getContentCompatationsUseCase.invoke(keyyword,offset,limit)
            Log.d("deneme",compatationList.value?.results.toString())



        }
    }
}