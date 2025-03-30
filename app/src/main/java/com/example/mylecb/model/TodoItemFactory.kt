package com.example.mylecb.model

import androidx.compose.runtime.mutableStateListOf
import com.example.week03.lab.model.TodoStatus

object TodoItemFactory {
//    fun makeTodoList() = mutableListOf(
//        Item("아침 명상하기", "02-01 05:30", TodoStatus.COMPLETED),
//        Item("오전 운동", "02-01 06:30", TodoStatus.PENDING),
//        Item("책 읽기", "02-01 08:30", TodoStatus.PENDING),
//        Item("점심 먹기", "02-01 12:30", TodoStatus.COMPLETED),
//        Item("모프 공부하기", "02-01 17:30", TodoStatus.PENDING)
//    )

    fun makeTodoList() = mutableStateListOf( //State가 추가됨으로써 리스트가 변경되면 리컴포저블이 일어나게끔함.
        Item("아침 명상하기", "02-01 05:30", TodoStatus.COMPLETED),
        Item("오전 운동", "02-01 06:30", TodoStatus.PENDING),
        Item("책 읽기", "02-01 08:30", TodoStatus.PENDING),
        Item("점심 먹기", "02-01 12:30", TodoStatus.COMPLETED),
        Item("모프 공부하기", "02-01 17:30", TodoStatus.PENDING)
    )
}

