package com.gbs.gbs_android.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gbs.gbs_android.R
import com.msg.gauthsignin.component.GAuthButton
import com.msg.gauthsignin.component.utils.Types

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToGAuth: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.weight(1f))
        Image(painter = painterResource(id = R.drawable.gbs_logo), contentDescription = "gbs_logo")
        Text(text = "GBS", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = modifier.height(45.dp))
        GAuthSignInButton(onClicked = { navigateToGAuth() })
        Spacer(modifier = modifier.weight(1f))
    }
}

@Composable
fun GAuthSignInButton(
    style: Types.Style = Types.Style.DEFAULT,
    actionType: Types.ActionType = Types.ActionType.SIGNIN,
    colors: Types.Colors = Types.Colors.OUTLINE,
    horizontalPaddingValue: Dp = 50.dp,
    onClicked: () -> Unit
) {
    GAuthButton(
        style,
        actionType,
        colors,
        horizontalPaddingValue
    ) {
        onClicked()
    }
}
