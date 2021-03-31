package com.example.myapplicationbyrohit;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)




public class SecondTest{

    @Rule
    public ActivityTestRule<ClientActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(ClientActivity.class);
    @Before
    public void setUp() throws Exception {
        //Before Test case execution
    }

    @Test
    public void testCase1() {

        //TestCase 2-a

        //Entering wrong phone number
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText("9074"));
        //Clicking the confirm button
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.editTextTextPersonName2)).check(matches(hasErrorText("Enter a valid phone number or email")));

        //TestCase 2-b

        //Entering wrong email
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText("gmail.com"));
        //Clicking the confirm button
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.editTextTextPersonName2)).check(matches(hasErrorText("Enter a valid phone number or email")));
    }

    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }
}

