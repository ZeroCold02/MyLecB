package com.example.bweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.bweek05a.R
import com.example.bweek05a.model.ButtonType
import com.example.bweek05a.model.ImageData
import com.example.bweek05a.model.ImageUri

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    

    val img1 by rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                imageUri = ImageUri.ResImage(R.drawable.img1),
                buttonType = ButtonType.EMOJI,
                likes = 50,
                dislikes = 10
            )
        )
    }
}