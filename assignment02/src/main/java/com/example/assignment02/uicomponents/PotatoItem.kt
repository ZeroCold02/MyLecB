package com.example.assignment02.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PotatoItem(isChecked:Boolean, label:String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        PotatoCheckBox(isChecked) { }
        Text(text = label)
    }
}

@Preview
@Composable
private fun PotatoItemPrev() {
    PotatoItem(true,"body")
}