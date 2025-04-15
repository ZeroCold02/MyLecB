package com.example.bweek05a.uicomponents

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bweek05a.model.ButtonType
import com.example.bweek05a.model.ImageData

@Composable
fun ImageList(
    imageList: MutableList<ImageData>,
    modifier: Modifier = Modifier,
    isVertical: Boolean = true // true: 세로(LazyColumn), false: 가로(LazyRow)
) {
    if (isVertical) {
        LazyColumn(modifier = modifier) {
            itemsIndexed(imageList) { index, item ->
                ImageListItem(item, index, imageList)
            }
        }
    } else {
        LazyRow(modifier = modifier) {
            itemsIndexed(imageList) { index, item ->
                ImageListItem(item, index, imageList)
            }
        }
    }
}

@Composable
private fun ImageListItem(
    item: ImageData,
    index: Int,
    imageList: MutableList<ImageData>
) {
    when (item.buttonType) {
        ButtonType.ICON -> {
            ImageWithButton(image = item.imageUri) {
                ButtonWithIcon(
                    likes = item.likes,
                    onClick = {
                        imageList[index] = item.copy(likes = item.likes + 1)
                    }
                )
            }
        }

        ButtonType.BADGE -> {
            ImageWithButton(image = item.imageUri) {
                ButtonWithBadge(
                    likes = item.likes,
                    onClick = {
                        imageList[index] = item.copy(likes = item.likes + 1)
                    }
                )
            }
        }

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
