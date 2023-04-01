package com.gbs.gbs_android.view.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gbs.gbs_android.view.components.BookCard
import com.gbs.gbs_android.view.search.component.SearchTextField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        var textValue by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 18.dp, end = 18.dp, top = 30.dp)
        ) {
            SearchTextField(
                hint = "책 이름, 저자, 출판사 등",
                value = textValue,
                onValueChange = { value -> textValue = value },
            )

            val list = listOf(1,2,3,4,5,6,7,8,9,10)     // test data(추후에 서버 데이터로 교체 예정)
            LazyColumn(modifier = Modifier.padding(top = 30.dp)) {
                items(items = list.chunked(2)) { rowItems ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        rowItems.forEach { item ->
                            BookCard(item, 170.dp)
                        }
                    }
                }
            }       // 추후 추가 예정
        }
    }
}

@Preview
@Composable
fun SearchPreview() {
    SearchScreen()
}