package com.example.bweek05a.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bweek05a.model.ImageData
import com.example.bweek05a.model.ImageListFactory

class ImageViewModel: ViewModel() {
    private val _imageList = ImageListFactory.makeImageList()
    val imageList: MutableList<ImageData>
        get() = _imageList
}