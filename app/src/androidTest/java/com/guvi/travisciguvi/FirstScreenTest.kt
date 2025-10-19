package com.guvi.travisciguvi

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class FirstScreenTest {
    @get:Rule
    val composableRule = createComposeRule()

    @Test
    fun testButtonClick(){
        composableRule.setContent {
            FirstScreen()
        }
        composableRule.onNodeWithTag("testButton").performClick()
        composableRule.onNodeWithTag("clickText").assertTextContains("Counter 1")
    }
}