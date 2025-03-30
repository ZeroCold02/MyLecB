package com.example.mylecb.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoCheckBox(
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit) {//state와 event를 매개변수로 받음.

    Checkbox(
        checked = isChecked,
//        onCheckedChange = {onCheckedChange(it)}
        onCheckedChange = { checked -> onCheckedChange(checked) } //매개변수 생략하고 it으로 써도 되고, checked와 같이 지정해서 써도 된다.
    )
}
//이런식으로 체크박스 컴포저블을 만들면, state, event를 원하는대로 넣어서 다양한곳에 재사용할 수 있겠지

@Preview
@Composable
private fun TodoCheckBoxPreview() {
    TodoCheckBox(true) {} //isChecked는 true로 주고, onCheckedChange 함수는 아무 기능 없이 빈 함수 넣음.(람다함수로 괄호밖)
}