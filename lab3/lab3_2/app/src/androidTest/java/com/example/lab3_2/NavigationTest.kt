package com.example.lab3_2

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)


class NavigationTest {

    @Before
    fun launchMainActivity() {
        launchActivity<MainActivity>()
    }

    @Test
    fun test1Navigation() {
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toFirst))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun test2Navigation() {
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toThird))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toFirst))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test3Navigation() {
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toThird))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test4Navigation() {
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toThird))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.pressBackUnconditionally()
        Espresso.onView(ViewMatchers.withId(fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.pressBackUnconditionally()
        ViewMatchers.withId(R.id.activity_main).matches(null)
    }
}