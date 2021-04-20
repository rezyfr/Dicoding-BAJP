package com.rezyfr.dicoding.bajp.ui.main

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.rezyfr.dicoding.bajp.R
import com.rezyfr.dicoding.bajp.ui.MainActivity
import com.rezyfr.dicoding.bajp.utils.EspressoIdlingResource
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }


    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource())
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
    fun assertDetailIsDisplayed() {
        onView(allOf(isDisplayed(), withId(R.id.rv_list)))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2,
                    click()
                )
            )
        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_date_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_description_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))
        onView(
            allOf(
                Matchers.instanceOf(AppCompatImageButton::class.java),
                withParent(withId(R.id.toolbar))
            )
        ).perform(click())
    }

    @Test
    fun addToFavorite(){
        onView(allOf(isDisplayed(), withId(R.id.rv_list)))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2,
                    click()
                )
            )
        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_date_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_description_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_favorite)).perform(click())
        onView(
            allOf(
                Matchers.instanceOf(AppCompatImageButton::class.java),
                withParent(withId(R.id.toolbar))
            )
        ).perform(click())
    }

    @Test
    fun removeFromFavorite(){
        onView(withMenuIdOrText(R.id.menu_favorite, R.string.menu_favorite)).perform(click());
        onView(allOf(isDisplayed(), withId(R.id.rv_list)))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.fab_favorite)).perform(click())
    }

    private fun withMenuIdOrText(@IdRes id: Int, @StringRes menuText: Int): Matcher<View?>? {
        val matcher: Matcher<View?> = withId(id)
        return try {
            onView(matcher).check(matches(isDisplayed()))
            matcher
        } catch (NoMatchingViewException: Exception) {
            openActionBarOverflowOrOptionsMenu(
                InstrumentationRegistry.getInstrumentation().targetContext
            )
            withText(menuText)
        }
    }
}