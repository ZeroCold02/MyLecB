package com.example.bweek05a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.bweek05a.model.ImageUri

@Composable
fun ImageWithButton(
    image: ImageUri, modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) {
    val img = when(image) {
        is ImageUri.ResImage -> image.resID
        is ImageUri.WebImage -> image.urlStr
    }
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = img,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        button()
    }
}

//@Composable
//fun ImageWithButton(
//    image: String, modifier: Modifier = Modifier,
//    button: @Composable () -> Unit
//) {
//    Column(modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//        AsyncImage(
//            model = image,
//            contentDescription = "",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(200.dp)
//                .clip(CircleShape)
//        )
//        button()
//    }
//
//
//}

//@Preview
//@Composable
//private fun ImageWithButtonPreview() {
//    //ButtonWithEmoji 에서 가져온 코드임.
//    var likes by remember { mutableStateOf(0) }
//    var dislikes by remember { mutableStateOf(0) }
//
//    ImageWithButton(image = R.drawable.img2) {
//        ButtonWithEmoji(likes, dislikes, { likes++ }, { dislikes++ })
//    }
//
//}