package com.example.assignment02.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment02.R

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val potatoStatus = remember {
        mutableStateMapOf(
            "arms" to true,
            "ears" to true,
            "eyebrows" to true,
            "eyes" to true,
            "glasses" to true,
            "hat" to true,
            "mouth" to true,
            "mustache" to true,
            "nose" to true,
            "shoes" to true
        )
    }

    val partNames = listOf(
        "arms", "ears", "eyebrows", "eyes", "glasses",
        "hat", "mouth", "mustache", "nose", "shoes"
    )

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
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box{
                // 몸통은 항상 표시
                Image(painter = painterResource(id = R.drawable.body), contentDescription = "body")

                // 나머지 부위는 상태에 따라 표시
                potatoParts.forEach { (name, resId) ->
                    if (potatoStatus[name] == true) {
                        Image(
                            painter = painterResource(id = resId),
                            contentDescription = name
                        )
                    }
                }
            }

            Row {
                Column {
                    for (i in 0 until 5) {
                        val part = partNames[i]
                        PotatoItem(
                            isChecked = potatoStatus[part] == true,
                            label = part,
                            onCheckedChange = { potatoStatus[part] = it }
                        )
                    }
                }
                Column {
                    for (i in 5 until 10) {
                        val part = partNames[i]
                        PotatoItem(
                            isChecked = potatoStatus[part] == true,
                            label = part,
                            onCheckedChange = { potatoStatus[part] = it }
                        )
                    }
                }
            }
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // 왼쪽: 인형 이미지
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                // 몸통 항상 표시
                Image(painter = painterResource(id = R.drawable.body), contentDescription = "body")

                // 나머지 부위 상태 따라 표시
                potatoParts.forEach { (name, resId) ->
                    if (potatoStatus[name] == true) {
                        Image(
                            painter = painterResource(id = resId),
                            contentDescription = name
                        )
                    }
                }
            }

            // 오른쪽: 체크박스 2열
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column {
                    for (i in 0 until 5) {
                        val part = partNames[i]
                        PotatoItem(
                            isChecked = potatoStatus[part] == true,
                            label = part,
                            onCheckedChange = { potatoStatus[part] = it }
                        )
                    }
                }
                Column {
                    for (i in 5 until 10) {
                        val part = partNames[i]
                        PotatoItem(
                            isChecked = potatoStatus[part] == true,
                            label = part,
                            onCheckedChange = { potatoStatus[part] = it }
                        )
                    }
                }
            }
        }
    }










}

@Preview
@Composable
private fun MainScreenPrew() {
    MainScreen()
}