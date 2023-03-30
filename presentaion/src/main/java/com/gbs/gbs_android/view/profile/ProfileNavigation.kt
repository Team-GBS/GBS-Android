package com.gbs.gbs_android.view.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gbs.gbs_android.view.search.SearchScreen
import com.gbs.gbs_android.view.search.searchRoute

const val profileRoute = "profile_route"

fun NavController.navigateToProfile() {
    this.navigate(profileRoute)
}

fun NavGraphBuilder.searchProfile() {
    composable(route = profileRoute) {
        ProfileScreen()
    }
}