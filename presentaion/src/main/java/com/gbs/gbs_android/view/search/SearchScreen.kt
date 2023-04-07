package com.gbs.gbs_android.view.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gbs.gbs_android.view.components.BookCard
import com.gbs.gbs_android.view.search.component.SearchTextField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(onCardClick: (Int) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        var textValue by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 18.dp, end = 18.dp, top = 30.dp),
        ) {
            SearchTextField(
                hint = "책 이름, 저자, 출판사 등",
                value = textValue,
                onValueChange = { value -> textValue = value },
            )

            val list = listOf(1,2,3,4,5,6,7,8,9,10)     // test data(추후에 서버 데이터로 교체 예정)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 40.dp)
                    .fillMaxWidth()
            ) {
                items(list) { item ->
                    // 아이템의 가로 비율을 같게 해주는 Box.
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .fillMaxSize()
                    ) {
                        BookCard(size = 200.dp, onCardClick = onCardClick, item = item)     // 가로의 크기는 고정되어 있어서 높이만 변경된다.
                    }
                }
            }       // 추후 추가 예정
        }
    }
}