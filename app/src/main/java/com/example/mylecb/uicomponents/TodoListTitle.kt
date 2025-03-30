package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylecb.R

@Composable
fun TodoListTitle(modifier: Modifier = Modifier) {
    val temp:String = stringResource(R.string.todolist_title)
    Text(
        text = "202111267 김찬영 / $temp",
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.padding(10.dp)
    )
}

@Preview
@Composable
private fun TodoListTitlePreview() {
    TodoListTitle()
}

