package com.example.cleanarcsample.utils.extensions

import kotlinx.coroutines.*

    fun CoroutineScope.launchOnIO(block : suspend CoroutineScope.() -> Unit) : Job {
        return launch(Dispatchers.IO, block = block)
    }

    fun launchOnIO(block : suspend CoroutineScope.() -> Unit) : Job {
        return CoroutineScope(SupervisorJob()).launchOnIO(block)
    }
