package com.example.bweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageList(imageList = imageList)
        }
//        LazyColumn(
//            modifier = modifier,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            items(imageList) { image ->
//                ImageItem(image = image)
//            }
//        }

    }else{
        Row(modifier = Modifier.fillMaxHeight().horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically){
            ImageList(imageList = imageList)
        }
    }

}