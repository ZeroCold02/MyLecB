package com.example.bweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.bweek05a.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.EMOJI,
            likes = 50,
            dislikes = 10
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.BADGE,
            likes = 50
        ),
        ImageData(
            imageUri = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.ICON,
            likes = 50
        )
    )
}