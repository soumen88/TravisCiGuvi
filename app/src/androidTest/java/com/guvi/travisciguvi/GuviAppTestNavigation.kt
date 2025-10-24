package com.guvi.travisciguvi

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.guvi.travisciguvi.navigation.AppNavHost
import com.guvi.travisciguvi.navigation.ScreenEnums
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GuviAppTestNavigation {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setUpTestingAppNavHost(){
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavHost().SetupAppNavigationHost(
                navHostController = navController
            )
        }
    }

    @Test
    fun verify_startDestinationInNavigation(){
        navController.assertCurrentRouteName(ScreenEnums.SplashScreen.name)
    }

    @Test
    fun startNavigationFromSplashScreen_ToHomeScreen(){
        val getStartedText = composeTestRule.activity.getString(R.string.get_started)
        val getStartedId = R.string.get_started
        composeTestRule.onNodeWithText(getStartedText).performClick()
        navController.assertCurrentRouteName(ScreenEnums.HomeScreen.name)
        /*composeTestRule.onNodeWithStringId(getStartedId).performClick()
        navController.assertCurrentRouteName(ScreenEnums.HomeScreen.name)*/
    }

    @Test
    fun startNavigationFromSplash_AndThenGoBack(){
        val getStartedText = composeTestRule.activity.getString(R.string.get_started)
        composeTestRule.onNodeWithText(getStartedText).performClick()
        navController.assertCurrentRouteName(ScreenEnums.HomeScreen.name)

        val goBackId = R.string.go_back
        composeTestRule.onNodeWithStringId(goBackId).performClick()
        navController.assertCurrentRouteName(ScreenEnums.SplashScreen.name)
    }

    @Test
    fun checkIfLogoIsPresent_OnSplashScreen(){
        val appLogo = composeTestRule.activity.getString(R.string.app_logo)
        composeTestRule.onNodeWithContentDescription(appLogo).assertExists()
    }
}