package com.sample.myapplication.uilayer.screens

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sample.myapplication.R
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
class DetailsScreenTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun test_details_screen_content_back_navigation_click() {
        composeTestRule.activity.setContent {
            Theme {
                ListScreen()
            }
        }

        composeTestRule.onNodeWithTag("List View").assertIsDisplayed()
        composeTestRule.onNodeWithText("Abraham Lincoln").assertIsDisplayed().performClick()

        val labelFirst = composeTestRule.activity.getString(R.string.label_first_name)
        composeTestRule.onNodeWithText(labelFirst).assertIsDisplayed()
        composeTestRule.onNodeWithText("Abraham").assertIsDisplayed()

        val labelLast = composeTestRule.activity.getString(R.string.label_last_name)
        composeTestRule.onNodeWithText(labelLast).assertIsDisplayed()
        composeTestRule.onNodeWithText("Lincoln").assertIsDisplayed()

        val labelDob = composeTestRule.activity.getString(R.string.label_dob)
        composeTestRule.onNodeWithText(labelDob).assertIsDisplayed()
        composeTestRule.onNodeWithText("21/01/1981").assertIsDisplayed()

        val labelAddress = composeTestRule.activity.getString(R.string.label_address)
        composeTestRule.onNodeWithText(labelAddress).assertIsDisplayed()
//        composeTestRule.onNodeWithText("Street 1, Road 1, City 1").assertIsDisplayed()

        val labelContact = composeTestRule.activity.getString(R.string.label_contact_number)
        composeTestRule.onNodeWithText(labelContact).assertIsDisplayed()
        composeTestRule.onNodeWithText("+1411111111").assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Back Navigation").assertIsDisplayed().performClick()
    }
}