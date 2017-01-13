package com.kylins.uitestdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by zhouliangshun on 2017/1/13.
 */

@RunWith(AndroidJUnit4.class)
public class ExampleEspressoTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testLoginSuccessLogin() {
        onView(allOf(withId(R.id.email), notNullValue())).perform(replaceText("326345851@qq.com"));
        onView(allOf(withId(R.id.password), notNullValue())).perform(replaceText("123456"));
        onView(allOf(withId(R.id.email_sign_in_button), notNullValue())).perform(click());
    }

    @Test
    public void testEmailFail() {


        onView(allOf(withId(R.id.email), notNullValue())).perform(replaceText("326345851"));
        onView(allOf(withId(R.id.email_sign_in_button), notNullValue())).perform(click());
        onView(allOf(withId(R.id.email))).check(matches(hasErrorText("This email address is invalid")));

    }

    @Test
    public void testPasswordFormatFail() {


        onView(allOf(withId(R.id.email), notNullValue())).perform(replaceText("326345851qq.com"));
        onView(allOf(withId(R.id.email_sign_in_button), notNullValue())).perform(click());
        onView(allOf(withId(R.id.password))).check(matches(hasErrorText("This password is too short")));

    }

    @Test
    public void testPasswordIncorrect() {

        onView(allOf(withId(R.id.email), notNullValue())).perform(replaceText("326345851@qq.com"));
        onView(allOf(withId(R.id.password), notNullValue())).perform(replaceText("12345"));
        onView(allOf(withId(R.id.email_sign_in_button), isDisplayed())).perform(click());
        onView(allOf(withId(R.id.password))).check(matches(hasErrorText("This password is incorrect")));

    }

}
