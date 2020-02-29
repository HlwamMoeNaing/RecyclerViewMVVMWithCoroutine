package com.hmn.recyclerviewmvvmwithcoroutine

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(view:ImageView,url:String){
    Glide.with(view).load("https://image.tmdb.org/t/p/w500/"+url)
        .into(view)
}