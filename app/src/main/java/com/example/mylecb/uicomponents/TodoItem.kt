package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylecb.model.Item
import com.example.week03.lab.model.TodoStatus

@Composable
fun TodoItem(item: Item, modifier: Modifier = Modifier) {
    //WC 엔터하면 Column 나옴
    Column {
        Text(
            text = item.content,
            fontSize = 16.sp,
            style = if (item.status == TodoStatus.COMPLETED) {
                TextStyle(textDecoration = TextDecoration.LineThrough)
            } else {
                TextStyle(textDecoration = TextDecoration.None)
            }
        )
        Spacer(modifier = Modifier.height(4.dp)) //오브젝트 사이에 여백 주고 싶을 떄 사용
        Text(
            text = item.time,
            fontSize = 10.sp
        )
    }
}

@Preview
@Composable
private fun TodoItemPreview() {
    Column {
        TodoItem(item = Item("모프 공부하기1", "03-25 12:38"))
        TodoItem(item = Item("모프 공부하기2", "03-25 13:38", TodoStatus.COMPLETED))
    }
}