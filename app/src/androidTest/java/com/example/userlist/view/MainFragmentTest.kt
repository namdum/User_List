/**
 * Author Eugene Brown
App: UserList
Class: MainFragmentTest
Usage: Tests the MainFragment UI
 **/
package com.example.userlist.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.userlist.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest{

  @Test
  fun testMainFragmentImg() {
    launchFragmentInContainer<MainFragment>()
    onView(withId(R.id.mainRV)).check(matches(isDisplayed()))
  }



}