package com.gbs.gbs_android.view.gauth

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gbs.gbs_android.BuildConfig
import com.msg.gauthsignin.GAuth
import com.msg.gauthsignin.GAuthSigninWebView

private const val GAUTH_KEY = BuildConfig.GAUTH_KEY
private const val GAUTH_KEY_SECRET = BuildConfig.GAUTH_KEY_SECRET

@Composable
fun GAuthScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize()
    ) {
        GAuthSignin()
    }
}

@Composable
fun GAuthSignin(
    clientId: String = GAUTH_KEY,
    Uri: String = "https://localhost:3000"
) {
    GAuthSigninWebView(
        clientId = clientId,
        redirectUri = Uri
    ) { code ->
        if (code.isNotEmpty()) {
            GAuth.getGAuthTokenRequest(
                code = code,
                clientId = GAUTH_KEY,
                clientSecret = GAUTH_KEY_SECRET,
                redirectUri = "https://localhost:3000"
            ) { token ->

            }
        }
    }
}