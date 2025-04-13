package com.example.assignment02.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.assignment02.R

@Composable
fun PartCheckbox(label: String,
                 checked: Boolean,
                 modifier: Modifier = Modifier,
                 onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(4.dp)) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(text = label)
    }
}



@Composable
fun CheckboxGrid(partStates: MutableMap<String, Boolean>,
    modifier: Modifier = Modifier) {
    val parts = partStates.keys.toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
//            .fillMaxWidth()
            .fillMaxSize()
//            .height(300.dp)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items(parts.size) {
            index ->
            val part = parts[index]
            PartCheckbox(
                label = part,
                checked = partStates[part] == true,
                onCheckedChange = {
                    checked ->
                    partStates[part] = checked
                }
            )
        }
    }
}

@Composable
fun NewMainScreen(modifier: Modifier = Modifier) {

    val partNames = listOf(
        "arms", "ears", "eyebrows", "eyes", "glasses",
        "hat", "mouth", "mustache", "nose", "shoes"
    )

    val partStates = remember(
    ) {
        mutableStateMapOf<String, Boolean>().apply {
            partNames.forEach{
                this[it] = true
            }
        }
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

    Image(painter = painterResource(id = R.drawable.body),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentScale = ContentScale.FillWidth)

    Column {
        Box{
            // 몸통은 항상 표시
            Image(painter = painterResource(id = R.drawable.body),
                contentDescription = "body",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentScale = ContentScale.FillWidth)

            // 나머지 부위는 상태에 따라 표시
            potatoParts.forEach { (name, resId) ->
                if (partStates[name] == true) {
                    Image(painter = painterResource(id = resId),
                        contentDescription = name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentScale = ContentScale.FillWidth)
                }
            }
        }

        CheckboxGrid(partStates = partStates)
    }


}

