/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.teatime

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This test demos a user clicking the decrement button and verifying that it properly decrease
 * the quantity the total cost.
 */

@RunWith(AndroidJUnit4::class)
class OrderActivityBasicTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<OrderActivity>(OrderActivity::class.java)

    @Test
    fun clickIncrementButton_ChangesQuantityAndCost() {
        // 1. Find View
        onView(withId(R.id.increment_button))
                // 2. Perform action on View
                .perform(click())
        // 3. Check our expectation
        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")))
        onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")))
    }

    @Test
    fun clickDecrementButton_ChangesQuantityAndCost() {
        // Check that the initial quantity is zero
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")))
        // Find View (decrement button)
        onView(withId(R.id.decrement_button))
        // Click on the decrement button
        .perform(click())
        // Verify that the decrement button won't decrease the quantity 0 and cost below $0.00
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")))
    }
}