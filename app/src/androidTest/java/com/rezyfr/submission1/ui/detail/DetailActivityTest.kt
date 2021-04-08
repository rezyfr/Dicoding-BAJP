package com.rezyfr.submission1.ui.detail

import androidx.appcompat.widget.AppCompatImageButton
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.rezyfr.submission1.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.junit.Before
import org.junit.Test

class DetailActivityTest {
    @Before
    fun setup() {
        ActivityScenario.launch(DetailActivity::class.java)
    }

    @Test
    fun assertViewIsDisplayed() {
        onView(
            allOf(
                instanceOf(AppCompatImageButton::class.java), withParent(withId(R.id.toolbar))
            )
        ).perform(click())
    }
}