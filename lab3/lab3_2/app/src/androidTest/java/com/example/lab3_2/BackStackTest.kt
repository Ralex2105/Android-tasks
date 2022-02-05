package com.example.lab3_2

import android.view.Gravity
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions


import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackStackTest {

    @Before
    fun launchMainActivity() {
        launchActivity<MainActivity>()
    }

    @Test
    fun test1BackStack() {
        onView(withId(toSecond))
            .perform(click())
        onView(withId(toThird))
            .perform(click())
        onView(withId(toFirst))
            .perform(click())
        onView(withId(toSecond))
            .perform(click())
        onView(withId(toFirst))
            .perform(click())
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.drawer_nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
        Espresso.pressBackUnconditionally()
        Espresso.pressBackUnconditionally()
        withId(R.id.activity_main).matches(null)
    }
    

    @Test
    fun test2BackStack() {
        onView(withId(toSecond))
            .perform(click())
        onView(withId(toThird))
            .perform(click())
        onView(withId(toFirst))
            .perform(click())
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open());
        onView(withId(R.id.drawer_nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
        Espresso.pressBackUnconditionally()
        Espresso.pressBackUnconditionally()
        withId(R.id.activity_main).matches(null)
    }

    @Test
    fun test3BackStack() {
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open());
        Espresso.pressBackUnconditionally()
        withId(R.id.activity_main).matches(null)
    }

    @Test
    fun test4BackStack() {
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.drawer_nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
        Espresso.pressBackUnconditionally()
        onView(withId(toSecond))
            .perform(click())
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.drawer_nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
        Espresso.pressBackUnconditionally()
        onView(withId(toFirst))
            .perform(click())
        Espresso.pressBackUnconditionally()
        withId(R.id.activity_main).matches(null)
    }

    @Test
    fun test5BackStack() {
        onView(withId(toSecond))
            .perform(click())
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.drawer_nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
        Espresso.pressBackUnconditionally()
        onView(withId(toThird))
            .perform(click())
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.drawer_nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
        Espresso.pressBackUnconditionally()
        Espresso.pressBackUnconditionally()
        withId(R.id.activity_main).matches(null)
    }
}