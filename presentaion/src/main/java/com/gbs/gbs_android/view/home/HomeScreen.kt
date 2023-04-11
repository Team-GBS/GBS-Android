package com.gbs.gbs_android.view.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.gbs.gbs_android.R
import com.gbs.gbs_android.view.components.BookCard
import com.gbs.gbs_android.view.components.HomeBookCard
import com.gbs.gbs_android.view.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onCardClick: (Int) -> Unit,
    onRequestButtonClick: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onRequestButtonClick() },
                modifier = modifier.background(Color(0xFFD5D7FE), shape = RoundedCornerShape(15.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.write),
                    contentDescription = "write"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "신간도서",
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 10.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
                textAlign = TextAlign.Center
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 40.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                val bookList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)     // 나중에 서버 데이터로 바꾸기
                items(bookList) { item ->
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .fillMaxWidth()
                    ) {
                        BookCardView(onCardClick, item)
                    }
                }
            }
        }

    }
}

@Composable
fun BookCardView(onCardClick: (Int) -> Unit, item: Int) {
    Column {
        Row {
            BookCard(size = 180.dp, item = item, onCardClick = onCardClick)
            BookCard(size = 180.dp, item = item, onCardClick = onCardClick)
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(
        onCardClick = { navController.navigate(Screen.DetailScreen.route) },
        onRequestButtonClick = { navController.navigate(Screen.BookRequestScreen.route) }
    )
}