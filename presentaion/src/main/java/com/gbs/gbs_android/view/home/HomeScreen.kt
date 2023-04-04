package com.gbs.gbs_android.view.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gbs.gbs_android.view.components.BookCard
import com.gbs.gbs_android.view.components.HomeBookCard
import com.gbs.gbs_android.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val bookList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* ... */ },
                modifier = modifier.background(Color(0xFFD5D7FE), shape = RoundedCornerShape(15.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.write),
                    contentDescription = "write"
                )
            }
        }
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp, top = 25.dp)
        ) {
            item {
                HomeBookCard()
            }

            items(bookList) {
                BookCardView()
            }
        }
    }
}

@Composable
fun HomeBookCard() {
    HomeBookCard(width = 375.dp, height = 200.dp)
}

@Composable
fun BookCardView() {
    Column {
        Row {
            BookCard(size = 180.dp)
            BookCard(size = 180.dp)
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}