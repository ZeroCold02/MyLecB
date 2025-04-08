package com.example.bweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bweek05a.viewmodel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val imageList = imageViewModel.imageList

//    var img1 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.EMOJI,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//    var img2 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.BADGE,
//                likes = 50
//            )
//        )
//    }
//    var img3 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.img3),
//                buttonType = ButtonType.ICON,
//                likes = 50
//            )
//        )
//    }

//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        ImageWithButton(image = img1.imageUri) {
//            ButtonWithEmoji(
//                likes = img1.likes,
//                dislikes = img1.dislikes,
////                onClickLikes = { img1.likes++ }, //이런식으로 작성하면 state 변화가 일어나지 않는다!! -> copy 해서 넣어야함!
//                onClickLikes = {
//                    img1 = img1.copy(likes = img1.likes+1)
//                },
//                onClickDisLikes = {
//                    img1 = img1.copy(dislikes = img1.dislikes+1)
//                }
//            )
//        }
//
//        ImageWithButton(image = img2.imageUri) {
//            ButtonWithBadge(
//                likes = img2.likes,
//                onClick = {
//                    img2 = img2.copy(likes = img2.likes+1)
//                }
//            )
//        }
//
//        ImageWithButton(image = img3.imageUri) {
//            ButtonWithIcon(
//                likes = img3.likes,
//                onClick = {
//                    img3 = img3.copy(likes = img3.likes+1)
//                }
//            )
//        }
//    }

}