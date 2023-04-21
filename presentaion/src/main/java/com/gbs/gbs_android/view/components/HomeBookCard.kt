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
fun HomeBookCard(
    width: Dp,
    height: Dp,
    item: Int,
    onCardClick: (Int) -> Unit
) {
    Column {
        Card(
            modifier = Modifier
                .width(width)
                .height(height),
            onClick = { onCardClick(item) },
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.wrapContentSize(),
                    painter = painterResource(id = R.drawable.empty_book_icon), // 서버에서 받아온 사진으로 교체 예정
                    contentDescription = "book thumbnail"
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 30.dp, start = 5.dp, end = 5.dp)
                .width(width),
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed " +
                    "ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}