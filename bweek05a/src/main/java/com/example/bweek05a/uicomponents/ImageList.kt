package com.example.bweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bweek05a.model.ButtonType
import com.example.bweek05a.model.ImageData

@Composable
fun ImageList(
    imageList: MutableList<ImageData>,
    modifier: Modifier = Modifier
) {
    imageList.forEachIndexed { index, item ->
        when (item.buttonType) {
            ButtonType.ICON -> {}
            ButtonType.BADGE -> {}
            ButtonType.EMOJI -> {
                ImageWithButton(image = item.imageUri) {
                    ButtonWithEmoji(
                        likes = item.likes,
                        dislikes = item.dislikes,
                        onClickLikes = {
                            imageList[index] = item.copy(likes = item.likes + 1)
                        },
                        onClickDisLikes = {
                            imageList[index] = item.copy(dislikes = item.dislikes + 1)
                        }
                    )
                }
            }
        }
    }
}