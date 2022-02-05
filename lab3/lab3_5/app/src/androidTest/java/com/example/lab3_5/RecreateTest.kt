package com.example.lab3_5

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecreateTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun launchMainActivity() {
        scenario = launchActivity()
    }

    @Test
    fun test1() {
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        scenario.onActivity {
            it.apply {
                requestedOrientation = (requestedOrientation + 1) % 2
            }
        }
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toSecond))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test2() {
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(toThird))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        scenario.onActivity {
            it.apply {
                requestedOrientation = (requestedOrientation + 1) % 2
            }
        }
        Espresso.onView(ViewMatchers.withId(fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toSecond))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toFirst))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}