package com.example.mylecb.model

import com.example.week03.lab.model.TodoStatus

data class Item(
    val content: String,
    val time: String,
    var status: TodoStatus = TodoStatus.PENDING
)