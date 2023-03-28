package com.gbs.gbs_android.view.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gbs.gbs_android.R
import com.msg.gauthsignin.GAuth
import com.msg.gauthsignin.GAuthSigninWebView
import com.msg.gauthsignin.component.GAuthButton
import com.msg.gauthsignin.component.utils.Types

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.weight(1f))
        Image(painter = painterResource(id = R.drawable.gbs_logo), contentDescription = null)
        Text(text = "GBS", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = modifier.height(45.dp))
        GAuthSigninButton()
        Spacer(modifier = modifier.weight(1f))
    }
}

@Composable
fun GAuthSignin(
    clientId: String,
    redirectUri: String
) {
    Log.d("signin", "signin")
    GAuthSigninWebView(
        clientId = clientId,
        redirectUri = redirectUri
    ) { response ->
        Log.d("signin", response)
    }
}

@Composable
fun GetGAuthTokenRequest(
    code: String,
    clientSecret: String,
    clientId: String,
    redirectUri: String
) {
    GAuth.getGAuthTokenRequest(
        code,
        clientSecret,
        clientId,
        redirectUri
    ) { response ->

    }
}

@Composable
fun TokenRefreshRequest(
    requestToken: String
) {
    GAuth.tokenRefreshRequest(
        requestToken
    ) { response ->

    }
}

@Composable
fun GetUserInfoRequest(
    accessToken: String
) {
    GAuth.getUserInfoRequest(
        accessToken
    ) { response ->

    }
}

@Composable
fun GetCodeInfoRequest(
    email: String,
    password: String
) {
    GAuth.getCodeInfoRequest(
        email,
        password
    ) { response ->

    }
}


@Composable
fun GAuthSigninButton(
    style: Types.Style = Types.Style.DEFAULT,
    actionType: Types.ActionType = Types.ActionType.SIGNIN,
    colors: Types.Colors = Types.Colors.OUTLINE,
    horizontalPaddingValue: Dp = 50.dp
) {
    GAuthButton(
        style,
        actionType,
        colors,
        horizontalPaddingValue
    ) {

    }
}

