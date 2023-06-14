package com.sample.myapplication.uilayer.screens

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sample.myapplication.uilayer.MainActivity
import com.sample.myapplication.uilayer.theme.Theme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ListScreenTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun test_list_screen_content_with_scroll() {
        composeTestRule.activity.setContent {
            Theme {
                ListScreen()
            }
        }
        composeTestRule.onNodeWithTag("List View").assertIsDisplayed()
        composeTestRule.onNodeWithText("Abraham Lincoln").assertIsDisplayed()
        composeTestRule.onNodeWithText("Street 1, Road 1, City 1").assertIsDisplayed()
        composeTestRule.onNodeWithTag("Column Scroll").performTouchInput { swipeUp() }
    }
}