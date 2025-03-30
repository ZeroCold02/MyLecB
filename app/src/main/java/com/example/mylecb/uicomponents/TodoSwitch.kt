package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodoSwitch(isChecked: Boolean,
               modifier: Modifier = Modifier,
               onCheckedChange: (Boolean) -> Unit) {
    Row (
         horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "미완료 항목만 보기",
            fontSize = 14.sp,
            modifier = Modifier.padding(5.dp))
        Switch(checked = isChecked,
            onCheckedChange = { checked -> onCheckedChange(checked) },
            modifier = Modifier.padding(5.dp))
    }
}

@Preview
@Composable
private fun TodoSwitchPrev() {
    TodoSwitch(true) { }
}