package com.example.bweek05a.model

sealed class ImageUri {
    data class ResImage(val resID:Int): ImageUri()
    data class WebImage(val urlStr:String): ImageUri()

}