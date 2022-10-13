package com.example.cleanarcsample.utils.extensions

import android.content.Context
import android.widget.Toast

infix fun Context.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()