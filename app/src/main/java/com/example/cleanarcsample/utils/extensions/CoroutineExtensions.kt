package com.example.cleanarcsample.utils.extensions

import kotlinx.coroutines.*

    fun CoroutineScope.launchOnIO(block : suspend CoroutineScope.() -> Unit) : Job {
        return launch(Dispatchers.IO, block = block)
    }

    fun CoroutineScope.launchOnMain(block : suspend CoroutineScope.() -> Unit) : Job {
        return launch(Dispatchers.Main, block = block)
    }

    fun <T> CoroutineScope.asyncOnIO(block : suspend CoroutineScope.() -> T) : Deferred<T> {
        return async(Dispatchers.IO, block = block)
    }

    fun <T> CoroutineScope.asyncOnMain(block : suspend CoroutineScope.() -> T) : Deferred<T> {
        return async(Dispatchers.Main, block = block)
    }

    fun launchOnIO(block : suspend CoroutineScope.() -> Unit) : Job {
        return CoroutineScope(SupervisorJob()).launchOnIO(block)
    }
