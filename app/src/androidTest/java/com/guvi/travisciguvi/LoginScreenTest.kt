package com.guvi.travisciguvi

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performKeyInput
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginScreenTest {
    @get:Rule
    val composableRule = createComposeRule()

    @Test
    fun testLoginScreen(){
        val email = "abcgmail.com"
        val password = "abcd1234"
        //val password = ""

        composableRule.setContent {
            LoginScreen()
        }

        composableRule.onNodeWithText("Type your email")
            .performTextInput(email)

        composableRule.onNodeWithText("Type your password")
            .performTextInput(password)

        composableRule.onNodeWithText("Login")
            .performClick()

        assertTrue(email.isNotEmpty())
        assertTrue(password.isNotEmpty())

        composableRule.onNodeWithText("Invalid Email").assertExists()

    }
}