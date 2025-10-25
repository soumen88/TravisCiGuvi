package com.guvi.travisciguvi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guvi.travisciguvi.BmiScreen
import com.guvi.travisciguvi.CounterScreen
import com.guvi.travisciguvi.HomeScreen
import com.guvi.travisciguvi.SplashScreen
import com.guvi.traviscipractice.GameScreen

class AppNavHost {
    @Composable
    fun SetupAppNavigationHost(
        navHostController: NavHostController,
        startDestinationScreen : String = ScreenEnums.GameScreen.name
    ){
        NavHost(
            navController = navHostController,
            startDestination = startDestinationScreen
        ){
            DisplaySplashScreenInNavigation(
                navHostController = navHostController,
                navGraphBuilder = this
            )
            DisplayHomeScreenInNavigation(
                navHostController = navHostController,
                navGraphBuilder = this
            )
            DisplayCounterScreenInNavigation(
                navHostController = navHostController,
                navGraphBuilder = this
            )
            DisplayGameScreenInNavigation(
                navHostController = navHostController,
                navGraphBuilder = this
            )
        }
    }

    fun DisplaySplashScreenInNavigation(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ){
        navGraphBuilder.composable(
            route = ScreenEnums.SplashScreen.name
        ){
            SplashScreen(
                navHostController = navHostController
            ) /// Navigate to home screen
        }
    }

    fun DisplayHomeScreenInNavigation(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ){
        navGraphBuilder.composable(
            route = ScreenEnums.HomeScreen.name
        ){
            HomeScreen(
                navHostController = navHostController
            )
        }
    }

    fun DisplayCounterScreenInNavigation(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ){
        navGraphBuilder.composable(
            route = ScreenEnums.CounterScreen.name
        ){
            CounterScreen()
        }
    }

    fun DisplayGameScreenInNavigation(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ){
        navGraphBuilder.composable(
            route = ScreenEnums.GameScreen.name
        ){
            GameScreen()
        }
    }
}