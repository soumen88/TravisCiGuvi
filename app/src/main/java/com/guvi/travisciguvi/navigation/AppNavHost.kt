package com.guvi.travisciguvi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guvi.travisciguvi.BmiScreen
import com.guvi.travisciguvi.HomeScreen
import com.guvi.travisciguvi.SplashScreen

class AppNavHost {
    @Composable
    fun SetupAppNavigationHost(
        navHostController: NavHostController,
        startDestinationScreen : String = ScreenEnums.SplashScreen.name
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
            DisplayBmiScreenInNavigation(
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

    fun DisplayBmiScreenInNavigation(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ){
        navGraphBuilder.composable(
            route = ScreenEnums.BmiScreen.name
        ){
            BmiScreen()
        }
    }
}