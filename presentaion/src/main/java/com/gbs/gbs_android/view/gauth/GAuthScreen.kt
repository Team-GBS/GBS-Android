package com.gbs.gbs_android.view.gauth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gbs.gbs_android.BuildConfig
import com.gbs.gbs_android.viewmodel.GAuthViewModel
import com.msg.gauthsignin.GAuth
import com.msg.gauthsignin.GAuthSigninWebView

private const val GAUTH_KEY = BuildConfig.GAUTH_KEY
private const val GAUTH_KEY_SECRET = BuildConfig.GAUTH_KEY_SECRET

@Composable
fun GAuthScreen(
    modifier: Modifier = Modifier,
    gAuthViewModel: GAuthViewModel = hiltViewModel(),
    navigateToHome: () -> Unit
) {
    Column(
        modifier.fillMaxSize()
    ) {
        GAuthSignin(
            setToken = gAuthViewModel::setToken,
            getToken = gAuthViewModel::getToken,
            navigateToHome = navigateToHome
        )
    }
}

@Composable
fun GAuthSignin(
    clientId: String = GAUTH_KEY,
    Uri: String = "https://localhost:3000",
    setToken: (String) -> Unit,
    getToken: () -> Unit,
    navigateToHome: () -> Unit
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
                redirectUri = Uri
            ) { token ->
                token.accessToken?.let {
                    setToken(it)
                    getToken()
                    navigateToHome()
                }
            }
        }
    }
}