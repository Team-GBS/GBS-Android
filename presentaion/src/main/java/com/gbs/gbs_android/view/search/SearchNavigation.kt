package com.gbs.gbs_android.view.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val searchRoute = "search_route"

fun NavController.navigateToSearch() {
    this.navigate(searchRoute)
}

fun NavGraphBuilder.searchScreen() {
    composable(route = searchRoute) {
        SearchScreen()
    }
}