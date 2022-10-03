package com.example.cleanarcsample.utils

import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Build.*
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.cleanarcsample.R
import kotlinx.android.synthetic.main.custom_loading_view.*


class Loading(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_loading_view)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)

        if (VERSION.SDK_INT >= VERSION_CODES.Q)
            progressBar.indeterminateDrawable.colorFilter = BlendModeColorFilter(
                ContextCompat.getColor(context, android.R.color.white),
                BlendMode.SRC_ATOP
            )
        else progressBar.indeterminateDrawable.setColorFilter(
            ContextCompat.getColor(
                context,
                android.R.color.white
            ), PorterDuff.Mode.SRC_ATOP
        )
    }
}