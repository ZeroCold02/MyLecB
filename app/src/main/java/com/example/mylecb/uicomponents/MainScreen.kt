package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mylecb.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
//        mutableStateListOf<Item>() 이렇게하면 빈 리스트를 생성하는거고
        TodoItemFactory.makeTodoList() //리스트 만들어둔거 받아오는거
    }

    Column { // 또는 fillMaxHeight()) {
        TodoListTitle()
        TodoList(todoList)
        Spacer(modifier = Modifier.weight(1f))
        TodoItemInput(todoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}