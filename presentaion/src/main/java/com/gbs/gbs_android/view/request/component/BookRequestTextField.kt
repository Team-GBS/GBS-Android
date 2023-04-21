package com.gbs.gbs_android.view.request.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookRequestTextField(
    value: String,
    hint: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 15.dp, bottom = 15.dp, end = 25.dp)
    ) {
        BasicTextField(
            value = value,
            textStyle = TextStyle(fontSize = 20.sp),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = hint,
                        color = Color(0xFFCAC9C9),
                        fontSize = 20.sp
                    )
                }
                innerTextField()
            },
            onValueChange = onValueChange
        )

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 0.5f.dp,
            color = Color(0xFFCAC9C9)
        )
    }
}