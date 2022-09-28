package com.example.digisample.utils

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String?, data: T?) : Resource<T>(data, message)
}