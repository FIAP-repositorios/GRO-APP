package com.gro.app.utils

import android.graphics.Color
import android.view.View
import androidx.appcompat.widget.Toolbar

fun toolbarConfig(
    toolbar : Toolbar,
    title : String
) {
    toolbar.title = title
    toolbar.setTitleTextColor(Color.WHITE)
    toolbar.textAlignment = View.TEXT_ALIGNMENT_CENTER
}