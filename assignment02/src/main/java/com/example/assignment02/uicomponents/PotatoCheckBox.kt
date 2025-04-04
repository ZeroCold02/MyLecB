package com.example.assignment02.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PotatoCheckBox(
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit) {

    Checkbox(
        checked = isChecked,
        onCheckedChange = {onCheckedChange(it)}
    )
}