package com.example.footballleague.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object BindingAdapters {
    @BindingAdapter(value = ["loadImage", "placeholder"], requireAll = false)
    @JvmStatic
    fun bindImage(imgView: ImageView, imgUrl: String?, placeHolder: Drawable?) {
        imgView.load(imgUrl) {
            placeholder(placeHolder)
            error(placeHolder)
        }
    }
}