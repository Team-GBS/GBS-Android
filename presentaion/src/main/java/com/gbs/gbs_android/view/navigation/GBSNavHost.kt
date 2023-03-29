package com.gbs.gbs_android.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.gbs.gbs_android.view.gauth.gAuthScreen
import com.gbs.gbs_android.view.gauth.navigateToGAuth
import com.gbs.gbs_android.view.home.homeScreen
import com.gbs.gbs_android.view.home.navigateToHome
import com.gbs.gbs_android.view.login.loginRoute
import com.gbs.gbs_android.view.login.loginScreen

@Composable
fun GBSNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = loginRoute) {
        loginScreen(navigateToGAuth = {
            navHostController.navigateToGAuth()
        })
        homeScreen()
        gAuthScreen(navigateToHome = {
            navHostController.navigateToHome()
        })
    }
}