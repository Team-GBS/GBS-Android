package com.gbs.gbs_android.view.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.gbs.gbs_android.view.gauth.gAuthScreen
import com.gbs.gbs_android.view.gauth.navigateToGAuth
import com.gbs.gbs_android.view.home.MainActivity
import com.gbs.gbs_android.view.login.loginRoute
import com.gbs.gbs_android.view.login.loginScreen

@Composable
fun GBSNavHost(navHostController: NavHostController, context: Context) {
    NavHost(navController = navHostController, startDestination = loginRoute) {
        loginScreen(navigateToGAuth = {
            navHostController.navigateToGAuth()
        })
        gAuthScreen(navigateToHome = {
            context.startActivity(Intent(context, MainActivity::class.java))
        })
    }
}