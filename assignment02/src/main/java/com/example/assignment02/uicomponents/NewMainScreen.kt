package com.example.assignment02.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment02.R


@Composable
fun NewMainScreen(modifier: Modifier = Modifier) {
    val partNames = listOf(
        "arms", "ears", "eyebrows", "eyes", "glasses",
        "hat", "mouth", "mustache", "nose", "shoes"
    )

    val checkedStates = rememberSaveable(
        saver = listSaver(
            save = { it.toList() },
            restore = { it.toMutableStateList() }
        )
    ) {
        mutableStateListOf(*Array(partNames.size) { true })
    }

    val potatoParts = listOf(
        "arms" to R.drawable.arms,
        "ears" to R.drawable.ears,
        "eyebrows" to R.drawable.eyebrows,
        "eyes" to R.drawable.eyes,
        "glasses" to R.drawable.glasses,
        "hat" to R.drawable.hat,
        "mouth" to R.drawable.mouth,
        "mustache" to R.drawable.mustache,
        "nose" to R.drawable.nose,
        "shoes" to R.drawable.shoes
    )

    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "202111267 김찬영", fontSize = 40.sp)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.body),
                    contentDescription = "body",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )

                potatoParts.forEachIndexed { index, (name, resId) ->
                    if (checkedStates[index]) {
                        Image(
                            painter = painterResource(id = resId),
                            contentDescription = name,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            CheckboxGrid(partNames = partNames, checkedStates = checkedStates)
        }
    } else {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.body),
                    contentDescription = "body",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )

                potatoParts.forEachIndexed { index, (name, resId) ->
                    if (checkedStates[index]) {
                        Image(
                            painter = painterResource(id = resId),
                            contentDescription = name,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                CheckboxGrid(
                    partNames = partNames,
                    checkedStates = checkedStates,
                    modifier = Modifier
                        .weight(1f)
                )

                Text(text = "202111267 김찬영", fontSize = 40.sp)
            }


        }
    }
}
