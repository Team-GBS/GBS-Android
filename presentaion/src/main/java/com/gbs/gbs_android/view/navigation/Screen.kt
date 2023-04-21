package com.gbs.gbs_android.view.navigation

// screen들의 route를 관리한다.
sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_route")
    object ProfileScreen: Screen("profile_route")
    object SearchScreen: Screen("search_route")
    object DetailScreen: Screen("detail_screen")
    object BookRequestScreen: Screen("request_screen")
}