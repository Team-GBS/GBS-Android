package com.gbs.gbs_android.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class GBSButtonBackGround {
    WHITE, BLACK, PINK
}

@Composable
fun GBSButton(
    text: String,
    background: GBSButtonBackGround,
    paddingHorizontalValue: Dp = 15.dp,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = paddingHorizontalValue, end = paddingHorizontalValue),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = when (background) {
                GBSButtonBackGround.BLACK -> Color.Black
                GBSButtonBackGround.PINK -> Color(0xFFFED5D5)
                GBSButtonBackGround.WHITE -> Color.White
            },
            contentColor = when (background) {
                GBSButtonBackGround.WHITE -> Color.Black
                else -> Color.White
            }
        )
    ) {
        Text(text = text)
    }
}