package com.jintin.contactscompose.ui.view

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import org.junit.Rule
import org.junit.Test

class HintTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displayTest() {
        composeTestRule.setContent {
            Hint("Welcome")
        }
        composeTestRule
            .onNodeWithText("Welcome")
            .assertIsDisplayed()
    }

}