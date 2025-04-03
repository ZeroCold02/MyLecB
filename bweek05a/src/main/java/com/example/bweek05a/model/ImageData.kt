package com.example.bweek05a.model

import androidx.compose.runtime.saveable.listSaver

data class ImageData(
    val imageUri: ImageUri,
    val buttonType: ButtonType = ButtonType.ICON,
    var likes: Int = 0,
    var dislikes: Int = 0
) {
    companion object {
        val imageSaver = listSaver<ImageData, Any>(
            //imageUri는 기본 데이터 타입이 아니니까, save할때 기본 구조로 쪼개줘야겠지.?
            //buttonType은 enum 클래스잖아. enum클래스는 그냥 저장할 수 있나봄 (name 을 사용해서 문자열로 저장)
            save = { item ->
                listOf(
                    when (item.imageUri) {
                        is ImageUri.ResImage -> item.imageUri.resID
                        is ImageUri.WebImage -> item.imageUri.urlStr
                    },
                    item.buttonType.name,
                    item.likes,
                    item.dislikes
                )
            },
            restore = { list ->
                val imgValue = list[0]
                val img = when (imgValue) {
                    is Int -> ImageUri.ResImage(imgValue)
                    is String -> ImageUri.WebImage(imgValue)
                    else -> throw IllegalArgumentException("타입 오류")
                }
                ImageData(
                    imageUri = img,
                    buttonType = ButtonType.valueOf(list[1] as String), //name으로 string이 되었던걸 다시 열거체 타입으로
                    likes = list[2] as Int,
                    dislikes = list[3] as Int
                )
            }
        )
    }


}
