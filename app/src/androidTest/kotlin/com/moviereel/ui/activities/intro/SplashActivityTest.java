package com.moviereel.ui.activities.intro;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.moviereel.R;
import com.moviereel.ui.intro.splash.SplashActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class SplashActivityTest {

    @Rule
    public ActivityTestRule<SplashActivity> activityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void testMovieIconShouldBeDisplayed(){
        onView(withId(R.id.appicon_splash)).check(matches(isDisplayed()));
    }

    @Test
    public void testAppNameIsDisplayed(){
        String actualAppName = activityTestRule.getActivity().getString(R.string.app_name);

        onView(withId(R.id.appname_splash)).check(matches(isDisplayed()));

        onView(withId(R.id.appname_splash)).check(matches(withText(actualAppName)));
    }

}