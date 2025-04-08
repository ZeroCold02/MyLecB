package com.example.bweek05a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bweek05a.R
import com.example.bweek05a.model.ButtonType
import com.example.bweek05a.model.ImageData
import com.example.bweek05a.model.ImageUri

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var img1 by rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                imageUri = ImageUri.ResImage(R.drawable.img1),
                buttonType = ButtonType.EMOJI,
                likes = 50,
                dislikes = 10
            )
        )
    }
    var img2 by rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                imageUri = ImageUri.ResImage(R.drawable.img2),
                buttonType = ButtonType.BADGE,
                likes = 50
            )
        )
    }
    var img3 by rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                imageUri = ImageUri.ResImage(R.drawable.img3),
                buttonType = ButtonType.ICON,
                likes = 50
            )
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageWithButton(image = img1.imageUri) {
            ButtonWithEmoji(
                likes = img1.likes,
                dislikes = img1.dislikes,
//                onClickLikes = { img1.likes++ }, //이런식으로 작성하면 state 변화가 일어나지 않는다!! -> copy 해서 넣어야함!
                onClickLikes = {
                    img1 = img1.copy(likes = img1.likes+1)
                },
                onClickDisLikes = {}
            )
        }
    }

}