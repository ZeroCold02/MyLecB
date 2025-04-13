package com.example.assignment02.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxGrid(
    partNames: List<String>,
    checkedStates: MutableList<Boolean>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items(partNames.size) { index ->
            PartCheckbox(
                label = partNames[index],
                checked = checkedStates[index],
                onCheckedChange = { checked ->
                    checkedStates[index] = checked
                }
            )
        }
    }
}