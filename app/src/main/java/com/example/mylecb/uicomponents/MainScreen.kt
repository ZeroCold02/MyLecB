package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mylecb.model.TodoItemFactory
import com.example.week03.lab.model.TodoStatus

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
//        mutableStateListOf<Item>() 이렇게하면 빈 리스트를 생성하는거고
        TodoItemFactory.makeTodoList() //리스트 만들어둔거 받아오는거
    }

    var onlyShowIncomplete by remember { mutableStateOf(false) }

    Column { // 또는 fillMaxHeight()) {
        TodoListTitle()
        TodoSwitch(
            isChecked = onlyShowIncomplete,
            onCheckedChange = { onlyShowIncomplete = it } // 이게 핵심!
        )
        val filteredList = if (onlyShowIncomplete) {
            todoList.filter { it.status == TodoStatus.PENDING }.toMutableList()
        } else {
            todoList
        }

        TodoList(filteredList)
        Spacer(modifier = Modifier.weight(1f))
        TodoItemInput(todoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}