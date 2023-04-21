package com.gbs.gbs_android.view.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gbs.gbs_android.R
import com.gbs.gbs_android.view.components.BookCard
import com.gbs.gbs_android.view.components.GBSButton
import com.gbs.gbs_android.view.components.GBSButtonBackGround

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    onCardClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 비율 설정하기
        Box(
            modifier = Modifier
            .weight(0.5f)
            .fillMaxWidth()
        ) {
            UserInfo()
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color((0xFFD9D9D9)),
            thickness = 1.5.dp
        )
        Box(
            modifier = Modifier
            .weight(1.5f)
            .fillMaxWidth()
        ) {
            UserBookInfo(onCardClick)
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color((0xFFD9D9D9)),
            thickness = 1.5.dp
        )
        Box(
            modifier = Modifier
            .weight(0.7f)
            .fillMaxWidth()
        ) {
            SettingButtons()
        }
    }
}

@Composable
fun UserInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp, end = 35.dp, top = 25.dp, bottom = 25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "3학년 4반 12번",
                style = TextStyle(fontSize = 17.sp)
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "임가람",
                style = TextStyle(fontSize = 18.sp)
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "프로필 수정",
                style = TextStyle(fontSize = 15.sp),
                color = Color(0xFF9E9E9E)
            )
        }

        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp),
            painter = painterResource(id = R.drawable.gbs_logo),
            contentDescription = "user profile"
        )
    }
}

@Composable
fun UserBookInfo(onCardClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp, top = 15.dp, end = 35.dp)
    ) {
        val tempList = listOf(1,2,3,4,5)
        Text(text = "북마크한 책", style = TextStyle(fontSize = 20.sp))
        LazyRow(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth()
        ) {
            items(tempList) { item ->
                BookCard(size = 85.dp, item = item, onCardClick = onCardClick)
            }
        }

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "대여한 책",
            style = TextStyle(fontSize = 20.sp)
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth()
        ) {
            items(tempList) { item ->
                BookCard(size = 85.dp, item = item, onCardClick = onCardClick)
            }
        }
    }
}

@Composable
fun SettingButtons() {
    Column(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 8.dp)
    ) {
        GBSButton(
            text = "위반사항",
            background = GBSButtonBackGround.WHITE,
            paddingHorizontalValue = 35.dp,
            onClick = { /*TODO*/ }
        )
        Spacer(modifier = Modifier.height(8.dp))
        GBSButton(
            text = "로그아웃",
            background = GBSButtonBackGround.PINK,
            paddingHorizontalValue = 35.dp,
            onClick = { /*TODO*/ }
        )
    }
}