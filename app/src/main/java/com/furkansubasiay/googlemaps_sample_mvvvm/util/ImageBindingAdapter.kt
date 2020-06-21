package com.furkansubasiay.googlemaps_sample_mvvvm.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */



@BindingAdapter("image")
fun loadImage(view: ImageView, characterImage: String) {
    Glide.with(view.context)
        .load(characterImage)
        .into(view)
}


