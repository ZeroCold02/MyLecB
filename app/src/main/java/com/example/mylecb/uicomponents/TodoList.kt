package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylecb.model.Item
import com.example.mylecb.model.TodoItemFactory
import com.example.week03.lab.model.TodoStatus

@Composable
fun TodoList(todoList: MutableList<Item>, modifier: Modifier = Modifier
        ,onItemCheckedChange: (Item) -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        todoList.forEachIndexed { index, item ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row {
                    TodoCheckBox(item.status == TodoStatus.COMPLETED) {
                        //item.status를 바꾸는건 안된데, 왜? item은 매개변수니까.
                        //코틀린의 매개변수는 모두 val 타입이라서 수정이 안되니까.
                        //그래서 index로 리스트에 직접 접근한다는데.

                        status -> //TodoCheckBox 함수의 두번째 매개변수인 함수는 (Boolean)->Unit 이니까, 아무튼 status로 매개변수 이름 정한거 boolean 타입이라는거.
//                        todoList[index] = item.copy(
//                            status = if (status) TodoStatus.COMPLETED
//                                    else TodoStatus.PENDING
//                        )
                        onItemCheckedChange(
                            item.copy(
                                status = if (status) TodoStatus.COMPLETED else TodoStatus.PENDING
                            )
                        )


                        //근데 여기서 사용하는 todoList도 TodoList 컴포저블 함수의 매개변수인거잖아.
                        //이건 왜 된다는거임? 이해가 안감.

                        //추가로 여기서 List가 변해도 리컴포저블은 안됨.
                        //그래서 List를 State로 사용해야한다고함.
                    }
                    TodoItem(item)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Preview
@Composable
private fun TodoListPreview() {
    TodoList(TodoItemFactory.makeTodoList()){}
}