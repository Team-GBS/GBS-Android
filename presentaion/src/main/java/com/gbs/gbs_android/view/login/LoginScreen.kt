package com.gbs.gbs_android.view.login

import android.util.Log
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gbs.gbs_android.BuildConfig
import com.gbs.gbs_android.R
import com.gbs.gbs_android.view.gauth.gauthRoute
import com.msg.gauthsignin.GAuth
import com.msg.gauthsignin.GAuthSigninWebView
import com.msg.gauthsignin.component.GAuthButton
import com.msg.gauthsignin.component.utils.Types

private const val GAUTH_KEY = BuildConfig.GAUTH_KEY
private const val GAUTH_KEY_SECRET = BuildConfig.GAUTH_KEY_SECRET
private const val redirectUri = "https://localhost:3000"


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    var isClicked by remember { mutableStateOf(false) }

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
        GAuth_Button(onClicked = { isClicked = true })
        Spacer(modifier = modifier.weight(1f))

        if (isClicked) {
            navController.navigate(gauthRoute)
//            GAuthSignin()
        }
    }
}

@Composable
fun GAuthSignin(
    clientId: String = GAUTH_KEY,
    Uri: String = redirectUri
) {
    GAuthSigninWebView(
        clientId = clientId,
        redirectUri = Uri
    ) { response ->
        Log.d("signin", response)
    }
}

@Composable
fun GetGAuthTokenRequest(
    code: String,
    clientSecret: String = GAUTH_KEY_SECRET,
    clientId: String = GAUTH_KEY,
    Uri: String = redirectUri
) {
    GAuth.getGAuthTokenRequest(
        code,
        clientSecret,
        clientId,
        Uri
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
fun GAuth_Button(
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
