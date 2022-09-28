package com.example.digisample.base

import com.example.digisample.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by DTFKAYMAZ on 28.09.2022.
 */

abstract class BaseRepository {

    suspend fun <T >safeApiCall(
        apiRequest : suspend () -> T) : Resource<T>
    {
        return withContext(Dispatchers.IO){
            try {
            Resource.Success(apiRequest.invoke())
            }catch (e : Exception){
                Resource.Error("Handle Error",null)
            }
        }
    }
}