package com.example.bweek05a.model

import androidx.compose.runtime.saveable.listSaver

data class ImageData (
    val imageUri: ImageUri,
    val buttonType: ButtonType = ButtonType.ICON,
    var likes:Int = 0,
    var dislikes:Int = 0
) {
    companion object{
        val imageSaver = listSaver<ImageData, Any>(
            save = {},
            restore = {}
        )
    }
}
