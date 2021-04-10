package com.rezyfr.dicoding.bajp.ui.main

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.rezyfr.dicoding.bajp.R
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assertViewIsDisplayed() {
        onView(withId(R.id.vp_main)).check(matches(isDisplayed()))
        onView(withId(R.id.tablayout_main)).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.tablayout_main), isDescendantOfA(withId(R.id.vp_main))))
    }

    @Test
    fun assetViewPagerSwipe() {
        onView(withId(R.id.vp_main)).perform(swipeLeft())
        onView(withId(R.id.vp_main)).perform(swipeRight())
    }

    @Test
    fun assertClickOnSpecificItem() {

        // won't work if using the same fragment for multiple list (since it's have the same id)
        // you can test it by comment out line 14 of MainViewPagerAdapter
//        onView(allOf(isDisplayed(), withId(R.id.rv_list)))
//            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
    }
}