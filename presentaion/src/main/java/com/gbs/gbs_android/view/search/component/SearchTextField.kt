package com.gbs.gbs_android.view.search.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gbs.gbs_android.R

@Composable
fun SearchTextField(
    hint: String,
    value: String,
    maxLines: Int = 1,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFEFEFEF))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            value = value,
            singleLine = true,
            maxLines = maxLines,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (value.isEmpty()) {
                        Text(text = hint, color = Color(0xFFCAC9C9))
                    }
                    innerTextField()
                }
            },
            onValueChange = onValueChange
        )
        Icon(
            modifier = Modifier
                .padding(end = 5.dp, start = 5.dp)
                .size(24.dp)
                .clickable {  },
            painter = painterResource(id = R.drawable.search_image),
            contentDescription = "search icon"
        )
    }
}