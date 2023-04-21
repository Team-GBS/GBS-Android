package com.gbs.gbs_android.view.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gbs.gbs_android.R
import com.gbs.gbs_android.view.components.GBSButton
import com.gbs.gbs_android.view.components.GBSButtonBackGround
import com.gbs.gbs_android.view.detail.component.BookmarkCheckBox

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 10.dp)
        ) {
            var checkedState by remember { mutableStateOf(false) }
            Spacer(modifier = Modifier.weight(1f))

            BookmarkCheckBox(checked = checkedState, onCheckedChange = { state -> checkedState = state })
        }

        Image(
            painter = painterResource(id = R.drawable.gbs_logo),
            contentDescription = "detail book thumbnail",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp),
        ) {
            Text(text = "해리포터 : 불의 잔", style = TextStyle(fontSize = 23.sp))

            Text(
                text = "책 상세 정보",
                modifier = Modifier.padding(top = 15.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )

            Divider(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                color = Color(0xFFF5F5F5),
                thickness = 3.dp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "저자", color = Color(0xFFCAC9C9), maxLines = 1)
                Text(text = "j.k 롤링", color = Color.Black, maxLines = 1)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "출판사", color = Color(0xFFCAC9C9), maxLines = 1)
                Text(text = "문학수첩", color = Color.Black, maxLines = 1)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "발행일", color = Color(0xFFCAC9C9), maxLines = 1)
                Text(text = "2000.11.01", color = Color.Black, maxLines = 1)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "쪽수", color = Color(0xFFCAC9C9), maxLines = 1)
                Text(text = "301쪽", color = Color.Black, maxLines = 1)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "무게", color = Color(0xFFCAC9C9), maxLines = 1)
                Text(text = "425g", color = Color.Black, maxLines = 1)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "크기", color = Color(0xFFCAC9C9), maxLines = 1)
                Text(text = "153 * 223 * 30mm", color = Color.Black, maxLines = 1)
            }

            GBSButton(text = "대여 예약", background = GBSButtonBackGround.BLACK, paddingHorizontalValue = 10.dp) {
                // onclick logic
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreen()
}