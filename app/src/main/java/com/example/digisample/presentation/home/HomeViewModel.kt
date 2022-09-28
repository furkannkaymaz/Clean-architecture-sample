package com.example.digisample.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digisample.data.home.model.CompetitionData
import com.example.digisample.domain.home.GetContentCompatationsUseCase
import com.example.digisample.utils.Resource
import com.example.digisample.utils.UIStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getContentCompatationsUseCase: GetContentCompatationsUseCase
) : ViewModel() {

    private val _compatationList = MutableLiveData<CompetitionData>()
    val compatationList: LiveData<CompetitionData> = _compatationList

    private val _state = MutableLiveData(UIStatus.LOADING)
    val state: LiveData<UIStatus> get() = _state

    init {
        getCompatations()
    }

    fun getCompatations() {

        viewModelScope.launch {
            when (val response = getContentCompatationsUseCase.invoke()) {
                is Resource.Success -> {
                    _compatationList.value = response.data!!
                    _state.value = UIStatus.SUCCESS
                }
                is Resource.Error -> {
                    _state.value = UIStatus.ERROR
                }
                else -> {
                    _state.value = UIStatus.ERROR
                }
            }
        }
    }
}