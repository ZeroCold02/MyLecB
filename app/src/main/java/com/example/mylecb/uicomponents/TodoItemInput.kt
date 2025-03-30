package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylecb.model.Item
import com.example.mylecb.model.TodoItemFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemInput(todoList:MutableList<Item>, modifier: Modifier = Modifier) {
    var textfieldState by remember {
        mutableStateOf("")
    }
    //by를 사용해서 remeber state를 선언할때는 getValue와 setValue가 import 되어야함. Alt+Enter로 쉽게 가능

    //WR 하면 Row 만들어짐
    Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) { //가로로 꽉 차게 만들려고 fillMaxWidth 속성 부여함.
        TextField(value = textfieldState,
            onValueChange = { content ->
                textfieldState = content
            }, //매개변수 생략하면 it으로 사용가능하고, 이처럼 content라고 매개변수 이름을 지정해주면 지정한 이름으로 사용하면 된다.
            placeholder = { Text("할 일을 입력하세요") }
        )

        Spacer(modifier = Modifier.width(15.dp))

        Button(onClick = {
            //여기 onClick에 클릭했을 때 해야되는 일은 우리보고 완성하라고 함.
            //상태는 무조건 Pending으로 넣고
            //textfieldState?로 할일 받아오면 되고
            //시간은 저번 시간에 실습한것처럼 넣으면 되지
            //그렇게 todoList에 삽입해주면 될듯?

            val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
            todoList.add(Item(textfieldState,currentTime))
            //이렇게 매개변수인 todoList에 add한다고 원본에도 삽입이 되나? ㅋㅋ

        }) {
            Text("추가")
        }
    }

}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())
    //버튼이랑 텍스트필드 딱 붙어있는게 별로니까 이번엔 width 써서 띄워주면 된다고 함.
}