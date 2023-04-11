package com.gbs.gbs_android.view.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gbs.gbs_android.R
import com.gbs.gbs_android.view.detail.DetailScreen
import com.gbs.gbs_android.view.home.HomeScreen
import com.gbs.gbs_android.view.profile.ProfileScreen
import com.gbs.gbs_android.view.request.BookRequestScreen
import com.gbs.gbs_android.view.search.SearchScreen

sealed class BottomNavItem(
    val icon: Int, val screenRoute: String
) {
    object Search: BottomNavItem(R.drawable.search_icon, Screen.SearchScreen.route)
    object Home: BottomNavItem(R.drawable.home_icon, Screen.HomeScreen.route)
    object Profile: BottomNavItem(R.drawable.profile_icon, Screen.ProfileScreen.route)
}

@Composable
fun GBSBottomNavigationView(navController: NavController) {
    val items = listOf(
        BottomNavItem.Search,
        BottomNavItem.Home,
        BottomNavItem.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF000000)
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                },
                selected = currentRoute == item.screenRoute,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.screenRoute
    ) {

        composable(BottomNavItem.Search.screenRoute) {
            SearchScreen(onCardClick = {
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(BottomNavItem.Home.screenRoute) {
            HomeScreen(
                onCardClick = { navController.navigate(Screen.DetailScreen.route) },
                onRequestButtonClick = { navController.navigate(Screen.BookRequestScreen.route) }
            )
        }
        composable(BottomNavItem.Profile.screenRoute) {
            ProfileScreen(onCardClick = {
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(Screen.DetailScreen.route) {
            DetailScreen()
        }
        composable(Screen.BookRequestScreen.route) {
            BookRequestScreen(onBackImageClick = {
                navController.navigate(Screen.HomeScreen.route)
            })
        }
    }
}