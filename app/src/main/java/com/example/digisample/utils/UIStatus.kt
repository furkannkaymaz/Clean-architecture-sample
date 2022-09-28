package com.example.digisample.utils

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */

enum class UIStatus {
    SUCCESS,
    ERROR,
    LOADING;

    fun isSuccessful() = this == SUCCESS

    fun isLoading() = this == LOADING

    fun isError() = this == ERROR
}