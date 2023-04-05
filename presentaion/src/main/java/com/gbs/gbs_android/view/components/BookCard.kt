package com.gbs.gbs_android.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gbs.gbs_android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCard(
    size: Dp,
    item: Int,
    onCardClick: (Int) -> Unit
) {
    Column {
        Card(
            onClick = { onCardClick(item) },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.size(size)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.empty_book_icon), // 서버에서 받아온 사진으로 교체 예정
                    contentDescription = "book thumbnail",
                    modifier = Modifier.wrapContentSize(),
                )
            }
        }

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed " +
                    "ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.",
            modifier = Modifier
                .padding(top = 8.dp, bottom = 30.dp, start = 5.dp, end = 5.dp)
                .width(size),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}