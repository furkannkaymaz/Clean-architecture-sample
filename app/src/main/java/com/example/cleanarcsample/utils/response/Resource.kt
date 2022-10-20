package com.example.cleanarcsample.utils.response

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    var state: UIStatus? = null
) {
    class Success<T>(data: T, state: UIStatus?) : Resource<T>(data, null, state)
    class Error<T>(message: String?, state: UIStatus?) : Resource<T>(null, message, state)
    class Loading<T>(state : UIStatus) : Resource<T>(null,null,state)
}