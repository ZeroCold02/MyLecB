package com.example.bweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bweek05a.viewmodel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {

    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    val scrollState = rememberScrollState()
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        ImageList(
            imageList = imageList,
            modifier = modifier,
            isVertical = true
        )
    }else{
        ImageList(
            imageList = imageList,
            modifier = modifier,
            isVertical = false
        )
    }

}