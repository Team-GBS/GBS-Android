package com.gbs.gbs_android.view.request

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gbs.gbs_android.view.components.GBSButton
import com.gbs.gbs_android.view.components.GBSButtonBackGround
import com.gbs.gbs_android.view.request.component.BookRequestTextField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BookRequestScreen(
    onBackImageClick: () -> Unit
) {
    var bookName by remember { mutableStateOf("") }
    var authorName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                .background(Color.Transparent),
        ) {
            IconButton(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .align(Alignment.CenterStart),
                onClick = { onBackImageClick() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back arrow",
                    tint = Color.Black
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                text = "도서 신청",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                ),
                color = Color.Black
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
        ) {
            Text(
                modifier = Modifier.padding(top = 25.dp, start = 25.dp),
                text = "책 이름",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            BookRequestTextField(value = bookName, hint = "예) 해리포터 불의 잔", onValueChange = { bookName = it })

            Text(
                modifier = Modifier.padding(top = 25.dp, start = 25.dp),
                text = "책 저자",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            BookRequestTextField(value = authorName, hint = "예) j.k 롤링", onValueChange = { authorName = it })
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp)
                .weight(1.5f)
        ) {
            Text(
                modifier = Modifier.padding(top = 25.dp),
                text = "이미지 첨부",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(260.dp)
                        .align(Alignment.CenterHorizontally),
                    imageVector = Icons.Default.Phone,
                    contentDescription = "gallery icon"
                )
            }

            GBSButton(
                text = "신청하기",
                background = GBSButtonBackGround.BLACK,
                onClick = { /*TODO*/ }
            )
        }
    }
}