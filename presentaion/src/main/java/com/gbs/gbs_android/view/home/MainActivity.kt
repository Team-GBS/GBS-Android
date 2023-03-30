package com.gbs.gbs_android.view.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gbs.gbs_android.ui.theme.GBS_AndroidTheme
import com.gbs.gbs_android.view.navigation.GBSBottomNavigationView
import com.gbs.gbs_android.view.navigation.NavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetBottomNav()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetBottomNav() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            GBSBottomNavigationView(navController = navController)
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            NavigationGraph(navController = navController)
        }
    }
}