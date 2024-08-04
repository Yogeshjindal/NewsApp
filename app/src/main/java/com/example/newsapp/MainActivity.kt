package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.presentation.navgraph.NavGraph
import com.example.newsapp.ui.NewsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = { viewModel.splashCondition.value })
        }
        setContent {
            NewsAppTheme(dynamicColor = false) {
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemUiColor = rememberSystemUiController()
                SideEffect {
                    systemUiColor.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }
                val navController = rememberNavController() // Create NavController
                // Add fillMaxSize()
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()) {
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}
