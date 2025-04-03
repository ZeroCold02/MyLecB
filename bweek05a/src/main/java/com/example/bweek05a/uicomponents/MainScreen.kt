package com.example.bweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.bweek05a.model.ImageData

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val img1 = rememberSaveable {
        mutableStateOf(
            ImageData(
                imageUri = TODO(),
                buttonType = TODO(),
                likes = TODO(),
                dislikes = TODO()
            )
        )
    }
}