package com.guvi.travisciguvi

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testList(){
        val listItems = mutableListOf<String>()
        val emptyListItems = emptyList<String>()
        for (i in 0..10){
            listItems.add("Item $i")
        }

        composeTestRule.setContent {
            ListScreen(
                itemsInList = listItems
            )
        }

        listItems.forEach { currentItem ->
            composeTestRule.onNodeWithText(currentItem).assertIsDisplayed()
        }
        composeTestRule.onNodeWithText("Item 4").performScrollTo()
        composeTestRule.onNodeWithText("Item 4").assertIsDisplayed()
        composeTestRule.onNodeWithText("Item 3").performClick()
        composeTestRule.onNodeWithText("Item found").assertExists()

        /*composeTestRule.setContent {
            emptyListItems
        }*/
    }
}