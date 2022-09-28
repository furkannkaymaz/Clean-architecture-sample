package com.example.digisample.data.home.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CompetitionData(
    val Data: Data? =null,
    val DisasterMode: Boolean,
    val HasAuth: Boolean,
    val Message: String? = null
)