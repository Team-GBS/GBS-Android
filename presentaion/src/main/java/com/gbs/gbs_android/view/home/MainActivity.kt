package com.gbs.gbs_android.view.home

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gbs.gbs_android.view.navigation.GBSBottomNavigationView
import com.gbs.gbs_android.view.navigation.NavigationGraph

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.setDecorFitsSystemWindows(false)
            SetBottomNav()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetBottomNav() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize().systemBarsPadding(),
        bottomBar = {
            GBSBottomNavigationView(navController = navController)
        }
    ) {
        NavigationGraph(navController = navController)
    }
}