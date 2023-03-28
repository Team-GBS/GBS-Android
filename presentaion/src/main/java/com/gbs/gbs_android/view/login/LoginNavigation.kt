package com.gbs.gbs_android.view.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val loginRoute = "login_route"

fun NavGraphBuilder.loginScreen() {
    composable(route = loginRoute) {
        LoginScreen()
    }
}