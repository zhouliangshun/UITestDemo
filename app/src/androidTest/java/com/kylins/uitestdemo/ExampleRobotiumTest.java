package com.kylins.uitestdemo;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.robotium.solo.Solo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by zhouliangshun on 2017/1/12.
 */

@RunWith(AndroidJUnit4.class)
public class ExampleRobotiumTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    Solo solo;

    @Before
   public void setUp() {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), loginActivityActivityTestRule.getActivity());
    }

    @Test
    public void testLoginSuccessLogin() {
        solo.enterText(0,"326345851@qq.com");
        solo.enterText(1,"123456");
        solo.clickOnButton(0);
    }

    @Test
    public void testEmailFail() {
        solo.enterText(0, "326345851");
        solo.clickOnButton(0);
        solo.searchText("This email address is invalid");
    }

    @Test
    public void testPasswordFormatFail() {
        solo.enterText(0, "326345851@qq.com");
        solo.clickOnButton(0);
        solo.searchText("This password is too short");
    }

    @Test
    public void testPasswordIncorrect() {
        solo.enterText(0, "326345851@qq.com");
        solo.enterText(1,"12345");
        solo.clickOnButton(0);
        solo.searchText("This password is incorrect");
    }

}
