package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
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
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(toThird))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(toFirst))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(toFirst))
            .perform(ViewActions.click())
        Espresso.openContextualActionModeOverflowMenu()
        Espresso.onView(ViewMatchers.withText(R.string.title_about))
            .perform(ViewActions.click())
        Espresso.pressBackUnconditionally()
        Espresso.pressBackUnconditionally()
        ViewMatchers.withId(R.id.activity_main).matches(null)
    }

    @Test
    fun test2BackStack() {
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(toThird))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(toFirst))
            .perform(ViewActions.click())
        Espresso.openContextualActionModeOverflowMenu()
        Espresso.onView(ViewMatchers.withText(R.string.title_about))
            .perform(ViewActions.click())
        Espresso.pressBackUnconditionally()
        Espresso.pressBackUnconditionally()
        ViewMatchers.withId(R.id.activity_main).matches(null)
    }

    @Test
    fun test3BackStack() {
        Espresso.openContextualActionModeOverflowMenu()
        Espresso.onView(ViewMatchers.withText(R.string.title_about))
            .perform(ViewActions.click())
        Espresso.pressBackUnconditionally()
        Espresso.pressBackUnconditionally()
        ViewMatchers.withId(R.id.activity_main).matches(null)
    }

    @Test
    fun test4BackStack() {
        Espresso.openContextualActionModeOverflowMenu()
        Espresso.onView(ViewMatchers.withText(R.string.title_about))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(ViewActions.click())
        Espresso.openContextualActionModeOverflowMenu()
        Espresso.onView(ViewMatchers.withText(R.string.title_about))
            .perform(ViewActions.click())
        Espresso.pressBackUnconditionally()
        Espresso.onView(ViewMatchers.withId(toFirst))
            .perform(ViewActions.click())
        Espresso.pressBackUnconditionally()
        ViewMatchers.withId(R.id.activity_main).matches(null)
    }

    @Test
    fun test5BackStack() {
        Espresso.onView(ViewMatchers.withId(toSecond))
            .perform(ViewActions.click())
        Espresso.openContextualActionModeOverflowMenu()
        Espresso.onView(ViewMatchers.withText(R.string.title_about))
            .perform(ViewActions.click())
        Espresso.pressBackUnconditionally()
        Espresso.onView(ViewMatchers.withId(toThird))
            .perform(ViewActions.click())
        Espresso.openContextualActionModeOverflowMenu()
        Espresso.onView(ViewMatchers.withText(R.string.title_about))
            .perform(ViewActions.click())
        Espresso.pressBackUnconditionally()
        Espresso.pressBackUnconditionally()
        Espresso.pressBackUnconditionally()
        ViewMatchers.withId(R.id.activity_main).matches(null)
    }
}