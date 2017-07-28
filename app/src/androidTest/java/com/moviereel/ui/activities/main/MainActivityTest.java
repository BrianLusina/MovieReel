package com.moviereel.ui.activities.main;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.moviereel.R;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/*** author lusinabrian*/
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testToolBarShouldBeVisible(){
        onView(withId(R.id.toolbar_main_id)).check(matches(isDisplayed()));
    }

    /*Perform user actions*/
    @Ignore("Opening drawer with MaterialDrawer library")
    @Test
    public void testClickingMenuIconShouldDisplayDrawer(){

        //onView(with)
    }
}