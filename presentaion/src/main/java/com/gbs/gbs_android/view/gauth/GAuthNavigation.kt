package com.gbs.gbs_android.view.gauth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val gAuthRoute = "gAuth_route"

fun NavController.navigateToGAuth() {
    this.navigate(gAuthRoute)
}

fun NavGraphBuilder.gAuthScreen(navigateToHome: () -> Unit) {
    composable(route = gAuthRoute) {
        GAuthScreen(navigateToHome =  navigateToHome)
    }
}