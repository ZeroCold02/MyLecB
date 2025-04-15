package com.example.bweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bweek05a.uiexamples.ScrollToTopButton
import com.example.bweek05a.viewmodel.ImageViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    val isVertical = orientation == Configuration.ORIENTATION_PORTRAIT

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }



    Box(modifier = modifier.fillMaxSize()) {
        ImageListWithScroll(
            imageList = imageList,
            isVertical = isVertical,
            listState = listState,
            modifier = Modifier.fillMaxSize()
        )

        if (isVertical) {
            AnimatedVisibility(visible = showButton) {
                ScrollToTopButton {
                    scope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }
}