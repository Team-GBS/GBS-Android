package com.gbs.gbs_android.view.gauth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val gauthRoute = "gauth_route"

fun NavController.navigateToGauth() {
    this.navigate(gauthRoute)
}

fun NavGraphBuilder.gauthScreen() {
    composable(route = gauthRoute) {
        GAuthScreen()
    }
}